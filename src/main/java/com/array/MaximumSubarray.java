package com.array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        // index of min < index of max
        int min = Math.min(0, sums[0]); // actually the curr sum in Kadane’s algorithm
        int max = sums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
            max = Math.max(max, sums[i] - min);
            min = Math.min(min, sums[i]);
        }

        return max;
    }


    // 1    2   3   4   -1  -2  -3
    // maximum = max - min =>
    public int maxSubArray2(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        int min = 0;

        for(int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            max = Math.max(prefix[i + 1] - min, max);
            min = Math.min(prefix[i + 1], min);
        }

        return max;
    }
}
