package com.interviews.dropbox.file_downloader;

import java.util.List;

public class ListFileDownloader {
    boolean isFileDone(List<Chuck> chucks, int size) {
        if (chucks == null || chucks.size() == 0) {
            return size == 0;
        }
        chucks.sort((a, b) -> a.start - b.start);

        //      [1, 3], [2, 3], [5, 6]
        // end
        if (chucks.get(0).start != 0) {
            return false;
        }
        int maxEnd = chucks.get(0).end;
        for(Chuck chuck : chucks) {
            int start = chuck.start;
            int end = chuck.end;

            if (start > maxEnd) {
                return false;
            }

            maxEnd = Math.max(end, maxEnd);
        }

        return maxEnd == size;
    }
}
