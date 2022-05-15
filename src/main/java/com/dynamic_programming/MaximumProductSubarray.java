package com.dynamic_programming;

public class MaximumProductSubarray {
    // https://leetcode.com/problems/maximum-product-subarray/discuss/48330/Simple-Java-code
    public int maxProduct(int[] nums) {
        // 0 positive 1 negative
        int[][] dp = new int[nums.length + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 1;
        int res = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i + 1][0] = Math.max(nums[i] * dp[i][0], nums[i]);
                dp[i + 1][1] = dp[i][1] * nums[i];
            } else {
                dp[i + 1][1] = Math.min(nums[i] * dp[i][0], nums[i]);
                dp[i + 1][0] = dp[i][1] * nums[i];
            }

            res = Math.max(res, dp[i + 1][0]);
        }

        return res;
    }

    public int maxProduct2(int[] nums) {
        int[][] dp = new int[nums.length][2]; // 0 - min, 1 - max

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            }

            max = Math.max(max, dp[i][1]);
        }

        return max;
    }
}
