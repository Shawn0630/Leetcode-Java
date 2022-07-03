package com.interviews.dropbox.web_crawler;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebCrawlerTests {
    private static final Map<String, List<String>> DEPENDENCY_GRAPH = new HashMap<String, List<String>>(){{
        put("http://a.com/a", Arrays.asList("http://a.com/b", "http://a.com/c"));
        put("http://a.com/b", Arrays.asList("http://a.com/d", "http://a.com/e"));
        put("http://a.com/c", Arrays.asList("http://a.com/d", "http://a.com/f"));
    }};

    WebCrawler webCrawler = new WebCrawler(new DefaultHtmlParser(DEPENDENCY_GRAPH));
    WebCrawlerMultithreaded webCrawlerMultithreaded = new WebCrawlerMultithreaded((new DefaultHtmlParser(DEPENDENCY_GRAPH)));

    @Test
    public void test() {
        webCrawlerMultithreaded.crawl("http://a.com/a");
    }

    @Test
    public void asyncTest() throws InterruptedException {
        List<String> ans = webCrawlerMultithreaded.crawlAsync("http://a.com/a");
        System.out.println(ans);
    }

}
