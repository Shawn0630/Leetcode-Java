package com.greedy;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int count = intervals.length;
        int last = 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[last][0] <= intervals[i][0] && intervals[last][1] >= intervals[i][1]) {
                count--;
            } else {
                last = i;
            }
        }
        return count;
    }
}
