package com.interviews.dropbox.web_crawler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class WebCrawlerMultithreaded implements Crawler {
    private static final int THREAD_COUNT = 10;
    private final HtmlParser htmlParser;

    public WebCrawlerMultithreaded(HtmlParser htmlParser) {
        this.htmlParser = htmlParser;
    }



    // https://leetcode.com/problems/web-crawler-multithreaded/discuss/1951047/Beats-100-in-Memory-Java-using-CompletableFuture-and-ExecutorService
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        String domain = startUrl.split("/")[2];

        //"http://news.yahoo.com
        Queue<Future<List<String>>> queue = new LinkedList<>();
        queue.add(executorService.submit(new CrawlerTask(startUrl, htmlParser)));
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        while (!queue.isEmpty()) {
            try {
                List<String> next = queue.poll().get();
                for(String url : next) {
                    if (!visited.contains(url) && url.contains(domain)) {
                        visited.add(url);
                        queue.offer(executorService.submit(new CrawlerTask(url, htmlParser)));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        executorService.shutdown();
        return new ArrayList<>(visited);
    }

    public List<String> crawlAsync(String startUrl) throws InterruptedException {
        Set<String> visited = ConcurrentHashMap.newKeySet();
        CrawlerRunnable crawlerRunnable = new CrawlerRunnable(htmlParser, startUrl, visited);
        new Thread(crawlerRunnable, "One").start();
        new Thread(crawlerRunnable, "Two").start();
        new Thread(crawlerRunnable, "Three").start();

        return new ArrayList<>(visited);
    }

    public static void main(String[] args) throws InterruptedException {
        // ["http://news.yahoo.com","http://news.yahoo.com/news","http://news.yahoo.com/news/topics/","http://news.google.com","http://news.yahoo.com/us"]
        //[[2,0],[2,1],[3,2],[3,1],[0,4]]
        //"http://news.yahoo.com/news/topics/"
        final Map<String, List<String>> DEPENDENCY_GRAPH = new HashMap<String, List<String>>(){{
            put("http://news.yahoo.com", Arrays.asList("http://news.yahoo.com/us"));
            put("http://news.yahoo.com/news", Arrays.asList());
            put("http://news.yahoo.com/news/topics/", Arrays.asList("http://news.yahoo.com", "http://news.yahoo.com/news"));
            put("http://news.google.com", Arrays.asList("http://news.yahoo.com/news/topics/", "http://news.yahoo.com/news"));
            put("http://news.yahoo.com/us", Arrays.asList());
        }};

        WebCrawlerMultithreaded webCrawlerMultithreaded = new WebCrawlerMultithreaded(new DefaultHtmlParser(DEPENDENCY_GRAPH));
        List<String> ans = webCrawlerMultithreaded.crawlAsync(
                "http://news.yahoo.com/news/topics/");
        System.out.println(ans);
    }


    @Override
    public List<String> crawl(String startUrl) {
        return crawl(startUrl, htmlParser);
    }
}


class CrawlerTask implements Callable<List<String>> {

    String url;
    HtmlParser parser;
    public CrawlerTask(String url, HtmlParser parser) {
        this.url = url;
        this.parser = parser;
    }

    @Override
    public List<String> call() throws Exception {
        return parser.getUrls(url);
    }
}

class CrawlerRunnable implements Runnable {

    HtmlParser parser;
    Queue<String> queue;
    Set<String> visited;
    int workingThread;
    String domain;
    public CrawlerRunnable(HtmlParser parser, String start, Set<String> visited) {
        this.parser = parser;
        this.workingThread = 0;
        this.visited = visited;
        this.queue = new LinkedList<>();
        this.queue.offer(start);
        this.visited.add(start);
        this.domain = start.split("/")[2];
    }

    @Override
    public void run() {
        while (true) {
            String url;
            synchronized (this) {
                while (queue.isEmpty()) {
                    if (workingThread == 0) {
                        return;
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                url = queue.poll();
                workingThread++;
            }

            List<String> nexts = parser.getUrls(url);

            synchronized (this) {
                for(String next : nexts) {
                    if (!visited.contains(next) && next.contains(domain)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
                workingThread--;
                notifyAll();
            }
        }
    }

    public Set<String> getVisited() {
        return visited;
    }
}
