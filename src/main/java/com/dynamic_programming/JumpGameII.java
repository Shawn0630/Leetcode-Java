package com.dynamic_programming;

public class JumpGameII {
    // greedy: https://leetcode.com/problems/jump-game-ii/discuss/1415525/Python-Greedy-Solution-with-explanation
    // dp:
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // the minimum step to ith position
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for(int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i) {
                    dp[i] = dp[i] == 0 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
                }
            }
        }


        return dp[nums.length - 1];
    }

    public int greedy_jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cur = nums.length - 1;
        int step = 0;

        while(cur > 0) {
            int temp = Integer.MAX_VALUE;
            for(int i = cur - 1; i >= 0; i--) {
                if (nums[i] + i >= cur) {
                    temp = i;
                }
            }
            step++;
            cur = Math.min(cur, temp);
        }

        return step;
    }
}
