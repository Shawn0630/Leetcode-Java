package com.dynamic_programming;

public class SplitArrayLargestSum {

    Integer[][] dp;
    public int splitArray(int[] nums, int m) {
        int[] sums = new int[nums.length];
        dp = new Integer[nums.length][m + 1];

        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }


        return splitArrayHelper(sums, nums.length - 1, m);
    }


    // 1    2       3    4     2

    //                 |
    //          |
    //     |

    // 1        4       4       3
    //                      |
    //              |
    // helper(3, 3)  => helper(2, 2), helper(1, 2), [helper(0, 2) -- invalid]
    // helper(2, 2)  => helper(0, 1), helper(1, 1)
    // helper(1, 2)  => helper(0, 1)
    private int splitArrayHelper(int[] sums, int end, int m) {
        if (dp[end][m] != null) {
            return dp[end][m];
        }

        if (m == 1) {
            dp[end][m] = sums[end];
            return dp[end][m];
        }


        int min = Integer.MAX_VALUE;
        for(int i = m - 2; i < end; i++) {
            int curMax = Math.max(splitArrayHelper(sums, i, m - 1), sums[end] - sums[i]);
            min = Math.min(curMax, min);
        }

        dp[end][m] = min;
        return dp[end][m];
    }
}
