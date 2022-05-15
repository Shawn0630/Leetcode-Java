package com.array.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    // intervals = [[1,4],[3,6],[2,8]]

    // [[1,2],[1,4],[3,4]]
    public int removeCoveredIntervals(int[][] intervals) {

        // [1, 4]        [2, 8]      [3, 6]
        //

        //      ----        -----           -------         ------          ------
        // ----          ------               ---              ------               ------

        //a[0] <= b[1]  b[0] <= a[1]
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[][] merged = new int[intervals.length][];
        int counter = 0;
        int mergedIdx = 0;

        merged[0] = intervals[0];
        counter = 1;
        for(int i = 1; i < intervals.length; i++) {
            if (hasOverlap(merged[mergedIdx], intervals[i])) {
                if (intervals[i][1] <= merged[mergedIdx][1]) {
                    continue;
                } else {
                    counter++;
                    intervals[mergedIdx][1] = intervals[i][1];
                }
            } else {
                counter++;
                merged[++mergedIdx] = intervals[i];
            }
        }

        return counter;
    }

    private boolean hasOverlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }
}
