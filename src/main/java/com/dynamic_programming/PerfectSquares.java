package com.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i * i < n + 1; i++) {
            dp[i * i] = 1;
            if (2 * i * i < n + 1) {
                dp[2 * i * i] = 2;
            }
        }

        for(int i = 2; i < n + 1; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 1; j--) {
                    if (dp[j] != Integer.MAX_VALUE && dp[i - j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                    }
                }
            }
        }

        return dp[n];

    }
}
