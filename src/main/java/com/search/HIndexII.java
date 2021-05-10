package com.search;

public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return -1;
        }

        int lo = 1, hi = citations.length;

        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (!(citations[citations.length - mid] >= mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo == 1 ? isHIndex(citations, 1) ? 1 : 0 : isHIndex(citations, lo) ? lo : lo - 1;
    }

    public boolean isHIndex(int[] citations, int h) {
        int index = citations.length - h;
        return citations[index] >= h && (index < 1 || citations[index - 1] < h);
    }
}
