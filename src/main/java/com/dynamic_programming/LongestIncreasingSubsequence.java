package com.dynamic_programming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for(int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] == Integer.MIN_VALUE) dp[i] = 1;
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }
}
