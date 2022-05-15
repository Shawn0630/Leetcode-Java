package com.dynamic_programming;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2]; // maximum amount at ith house, 0 - not rob, 1 - rob

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }


        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
