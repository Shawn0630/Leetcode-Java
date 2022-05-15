package com.search.backtracking;

public class CombinationSumIV {
    Integer[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        return combinationSumDFS(nums, target);
    }

    private int combinationSumDFS(int[] nums, int remaining) {
        if (remaining < 0) {
            return 0;
        }
        if (remaining == 0) {
            return 1;
        }
        if (dp[remaining] != null) {
            return dp[remaining];
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count += combinationSumDFS(nums, remaining - nums[i]);
        }

        dp[remaining] = count;
        return dp[remaining];
    }
}
