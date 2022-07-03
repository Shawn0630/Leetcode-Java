package com.interviews.dropbox.web_crawler;

import java.util.ArrayList;
import java.util.List;

public class WebCrawler implements Crawler {
    private final HtmlParser htmlParser;

    public WebCrawler(HtmlParser htmlParser) {
        this.htmlParser = htmlParser;
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> ans = new ArrayList<>();
        String hostname = startUrl.split("/")[2].split(":")[0];

        crawlHelper(startUrl, htmlParser, ans, hostname);

        return ans;
    }

    private void crawlHelper(String startUrl, HtmlParser htmlParser, List<String> cur, String hostname) {
        cur.add(startUrl);

        List<String> nexts = htmlParser.getUrls(startUrl);

        for(String next : nexts) {
            if(next.contains(hostname) && !cur.contains(next)) {
                crawlHelper(next, htmlParser, cur, hostname);
            }
        }
    }

    @Override
    public List<String> crawl(String startUrl) {
        return crawl(startUrl, htmlParser);
    }
}
