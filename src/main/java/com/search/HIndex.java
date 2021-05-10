package com.search;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int lo = 0, hi = citations.length - 1;
        int ans = 0; // h ~ 0

        // h ~ [0, n]

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int h = citations.length - mid;
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] > h) {
                ans = h;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

//    public boolean isHIndex(int[] citations, int h) {
//        // h = 0 -> h = 1
//        // n papers have at least h citations each, and the other n − h papers have no more than h
//        // n = 3 have at least 1 citations, other 2 have no more than 1
//        // a[2] >= 1, a[0..1] < 1
//        int index = citations.length - h - 1;
//        return (citations[index] >= h + 1) && (index < 1 || citations[index - 1] <= h + 1);
//    }
}
