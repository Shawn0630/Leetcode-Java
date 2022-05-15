package com.array.intervals;

import com.stack.MinimumInsertionstoBalanceaParenthesesString;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinimumNumberofArrowstoBurstBalloons {
    // [[10,16],[2,8],[1,6],[7,12]]
    // not merging, but overlap
    // [2,6], [7,12], [10,12]
    // minimal overlap

    // ---
    //   ------
    //     --

    //  --
    //      ----

    // https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93735/A-Concise-Template-for-%22Overlapping-Interval-Problem%22
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int counter = 0;
        //[1,6]     [2,8]   [7,12]      [10,16]

        int[][] intervals = new int[points.length][];
        int idx = 0;
        intervals[idx] = points[0];


        //[6,6][9,10]
        //[0,9],[0,6][2,9][2,8][3,9][3,9][3,8][6,8][7,12][9,10]
        for(int i = 1; i < points.length; i++) {
            int[] overlap = intervals[idx];
            int max = Math.max(overlap[0], points[i][0]);
            int min = Math.min(overlap[1], points[i][1]);
            if (max <= min) { // overlap;
                intervals[idx] = new int[]{max, min};
            } else {
                intervals[++idx] = points[i]; // largest endings
            }
        }

        return idx + 1;
    }

    public int[][] mergeIntervals(int[][] points) {
        if(points == null || points.length == 0) {
            return null;
        }
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int counter = 0;
        //[1,6]     [2,8]   [7,12]      [10,16]

        int[][] intervals = new int[points.length][];
        int idx = 0;
        intervals[idx] = points[0];

        for(int i = 1; i < points.length; i++) {
            int[] overlap = intervals[idx];
            int max = Math.max(overlap[0], points[i][0]);
            int min = Math.min(overlap[1], points[i][1]);
            if (max <= min) {
                int start = Math.min(overlap[0], points[i][0]);
                int end = Math.max(overlap[1], points[i][1]);
                intervals[idx] = new int[]{start, end};
            } else {
                intervals[++idx] = points[i];
            }
        }

        return Arrays.copyOf(intervals, idx + 1);
    }


    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons minimumNumberofArrowstoBurstBalloons = new MinimumNumberofArrowstoBurstBalloons();
//        minimumNumberofArrowstoBurstBalloons.findMinArrowShots(new int[][]{
//                {3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}});
        minimumNumberofArrowstoBurstBalloons.mergeIntervals(new int[][]{{10,16},{2,8},{1,6},{7,12}});
    }
}
