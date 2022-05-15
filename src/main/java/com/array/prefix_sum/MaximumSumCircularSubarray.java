package com.array.prefix_sum;

import com.array.intervals.MergeIntervals;

public class MaximumSumCircularSubarray {
    // https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/775875/3-questions-1-approach-Python
    //         0   1    2   3   4   5   6   7
    //        [1,  -2,  3,  -2, 1,  -2,  3,  -2]
    // curMin  1    -2  -2  -4
    //  min    1    -2  -2  -4
    //  max    1    1

    //          [-3,     -2,     -3]   -8
    //  curMax    -3     -2      -2
    //  max       -3     -2      -2
    //  curMin    -3     -3      -3
    //  min       -3     -3      -3
    public int maxSubarraySumCircular(int[] nums) {
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];
        int min = nums[0];
        int prefix = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefix = prefix + nums[i];
            curMax = Math.max(nums[i], curMax + nums[i]);
            curMin = Math.min(nums[i], curMin + nums[i]);//
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
        }

        return prefix == min ? max: Math.max(max, prefix - min);

    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        maximumSumCircularSubarray.maxSubarraySumCircular(new int[]{-3, -2, -3});
    }
}
