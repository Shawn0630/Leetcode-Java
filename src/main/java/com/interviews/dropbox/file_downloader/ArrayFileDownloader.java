package com.interviews.dropbox.file_downloader;

import java.util.Arrays;

public class ArrayFileDownloader {
    public boolean isDone(Chuck[] chucks, int size) {
        Arrays.sort(chucks, (a, b) -> a.start - b.start);

        int maxEnd = 0;

        for(Chuck chuck : chucks) {
            if (chuck.start > maxEnd) {
                return false;
            }
            maxEnd = Math.max(maxEnd, chuck.end);
        }

        return maxEnd == size;
    }
}
