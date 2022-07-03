package com.interviews.dropbox.web_crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultHtmlParser implements HtmlParser {

    Map<String, List<String>> dependencyGraph;

    public DefaultHtmlParser(Map<String, List<String>> dependencyGraph) {
        this.dependencyGraph = dependencyGraph;
    }

    @Override
    public List<String> getUrls(String url) {
        return dependencyGraph.getOrDefault(url, new ArrayList<>());
    }
}
