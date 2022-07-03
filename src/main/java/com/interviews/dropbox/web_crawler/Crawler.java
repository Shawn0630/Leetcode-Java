package com.interviews.dropbox.web_crawler;

import java.util.List;

public interface Crawler {
    public List<String> crawl(String startUrl);
}
