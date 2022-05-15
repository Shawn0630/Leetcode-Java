package com.array.intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeIntervals {

    // [[1,3],[2,6],[8,10],[15,18]] sorted
    // [[1, 6], [8, 10], [15, 18]]

    // [[1, 5], [2, 3], [3,6]]
    //[[1,6]]
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else { // a[0] == b[0]
                return a[1] - b[1];
            }
        });

        int[][] ans = new int[intervals.length][];
        int idx = 0;


        // a b c d
        // a b => e, c
        int i = 0;
        while (i < intervals.length) {
            ans[idx] = intervals[i];
            while (i < intervals.length && isOverlap(ans[idx], intervals[i])) {
                ans[idx][0] = Math.min(ans[idx][0], intervals[i][0]);
                ans[idx][1] = Math.max(ans[idx][1], intervals[i][1]);
                i++;
            }
            idx++;
        }

        return Arrays.copyOf(ans, idx);
    }


    // [1, 3] [2, 6]
    // [1, 5] [2, 3]
    private boolean isOverlap(int[] a, int[] b) { // a, b sorted
        int left = Math.max(a[0], b[0]); // 2
        int right = Math.min(a[1], b[1]); // 3

        return left <= a[1] && right >= b[0];
    }


    public int[][] merge2(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
        }

        int[][] ans = new int[intervals.length][];
        int idx = 0;
        int count = 0, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for(int k : map.keySet()) {
            count += map.get(k);
            start = Math.min(start, k);
            end = Math.max(end, k);

            if (count == 0) {
                ans[idx++] = new int[]{start, end};
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
            }
        }

        return Arrays.copyOf(ans, idx);
    }
}
