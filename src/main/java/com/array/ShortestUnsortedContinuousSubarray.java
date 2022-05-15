package com.array;

public class ShortestUnsortedContinuousSubarray {
    //       0   1   2   3   4   5   6
    //      [2,  6,  4,  8,  10, 9,  15]
    //           |               |
    //
    //
    //
    //  2       6       4       8       10      9       15
    //
    //
    //
    //
    //
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = nums.length - 1;

        int cur_min = Integer.MAX_VALUE, cur_max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (cur_max < nums[i]) {
                cur_max = nums[i];
            } else {
                end = i;
            }
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            if (cur_min > nums[i]) {
                cur_min = nums[i];
            } else {
                start = i;
            }
        }


        return start == -1 ? 0 : end - start + 1;
    }
}
