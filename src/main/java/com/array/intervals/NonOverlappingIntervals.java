package com.array.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    // [[1,2],[2,3],[3,4],[1,3]]
    // [[1,2],[1,3],[2,3],[3,4]
    //   j     i,j

    // [[1, 6], [2, 3], [5, 6]]  => 1
    //   i        j
    // https://leetcode.com/problems/non-overlapping-intervals/discuss/1283600/C%2B%2B-or-Explained-or-Greedy-and-DP-or
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int counter = 0;
        int prev = 0;

        for(int i = 1; i < intervals.length; i++) {
            if(isOverlap(intervals[prev], intervals[i])){ // overlapping
                if(intervals[prev][1] > intervals[i][1]){ // total overlap, move ahead & removeCount++
                    prev = i;
                }
                counter++;    // partial overlap, only removeCount++; (no need to move ahead)
            }
            else { // no overlap, just move ahead, no change remove count
                prev = i;
            }
        }



        return counter;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int counter = 0;
        int prev = 0;
        int cur = 1;

        // [1,2],		[1,3],		[2,3],		[3,4]
        //  prev         cur
        //  prev                     cur
        //  prev                                cur
        while (cur < intervals.length) {
            if (isOverlap2(intervals[prev], intervals[cur])) {
                if (intervals[prev][1] > intervals[cur][1]) {
                    prev = cur;
                    cur++;
                } else {
                    cur++;
                }
                counter++;
            } else {
                prev = cur;
                cur++;
            }
        }


        return counter;
    }

    // [1, 2], [2, 3] => false
    // start = 2, end = 2
    // [1, 6] [2, 3] => true
    // start = 2, end = 3
    private boolean isOverlap(int[] a, int [] b) {
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);

        return start < a[1] && end > b[0];
    }

    private boolean isOverlap2(int[] a, int [] b) {
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);

        return start < end;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        nonOverlappingIntervals.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}});
    }
}
