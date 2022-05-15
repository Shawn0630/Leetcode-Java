package com.array;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int[] diff = new int[nums.length - 1];

        for(int i = 1; i < nums.length; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }

        int[] dp = new int[diff.length];

        // 1    2   3   4   5
        //          1
        //              1
        //                  1
        dp[0] = 0;
        int counter = 0;
        for(int i = 1; i < diff.length; i++) {
            if (diff[i] == diff[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = 0;
            }

            counter += dp[i];
        }

        return counter;

    }
}
