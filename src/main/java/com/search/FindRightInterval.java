package com.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        int[][] sorted = new int[intervals.length][];
        System.arraycopy(intervals, 0, sorted, 0, intervals.length);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        int[] ans = new int[intervals.length];


        for(int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];

            int lo = 0, hi = intervals.length - 1;
            int index = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;

                if (cur[1] == sorted[mid][0]) {
                    index = map.get(sorted[mid][0]);
                    break;
                } else if (cur[1] > sorted[mid][0]) {
                    lo = mid + 1;
                } else {
                    index = map.get(sorted[mid][0]);
                    hi = mid - 1;
                }
            }
            ans[i] = index;
        }

        return ans;
    }

}
