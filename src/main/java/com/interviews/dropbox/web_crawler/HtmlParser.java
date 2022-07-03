package com.interviews.dropbox.web_crawler;

import java.util.List;

interface HtmlParser {
    List<String> getUrls(String url);
}