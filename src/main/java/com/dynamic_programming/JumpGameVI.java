package com.dynamic_programming;

import java.util.Arrays;

public class JumpGameVI {
    // https://leetcode.com/problems/jump-game-vi/discuss/1363357/DP-greaterTLE-or-MaxHeap-greater-Accepted-or-Both-Solutions-or-Cpp
    public int maxResult(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= Math.max(0, i - k); j--) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }

        return dp[nums.length - 1];
    }
}
