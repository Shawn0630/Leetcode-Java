package com.interviews.dropbox.file_downloader;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapFileDownloader implements StreamFileDownloader {
    Map<Integer, Integer> treeMap;
    int size;

    public TreeMapFileDownloader(int size) {
        treeMap = new TreeMap<>();
        this.size = size;
    }

    @Override
    public boolean isFileDone() {
        if (!treeMap.containsKey(0) || !treeMap.containsKey(size)) {
            return false;
        }

        int counter = 0;
        int start = 0;
        int end = 0;
        for(int bit : treeMap.keySet()) {
            counter += treeMap.get(bit);
            start = Math.min(start, bit);
            end = Math.min(end, bit);

            if (counter == 0) {
                if (start == 0 && end == size) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    // [0,2][1,3] 4
    // 0 - 1
    // 2 - -1
    // 1 - 1
    // 3 - -1
    @Override
    public void addBlock(Chuck chuck) {
        treeMap.put(chuck.start, treeMap.getOrDefault(chuck.start, 0) + 1);
        treeMap.put(chuck.end, treeMap.getOrDefault(chuck.end, 0) - 1);
    }
}
