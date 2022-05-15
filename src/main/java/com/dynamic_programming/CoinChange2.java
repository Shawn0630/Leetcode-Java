package com.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange2 {
    //https://leetcode.com/problems/coin-change-2/discuss/676672/DFS-with-memorizationPython-or-Beat-42-or-Easy-to-understand
    //https://leetcode.com/problems/coin-change-2/discuss/1135391/Java-clean-2D1D-DP-Solution-oror-detailed-comments
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[amount + 1][coins.length];

        changeDFS(amount, coins.length - 1, coins);

        return dp[amount][coins.length - 1];

    }

    private int changeDFS(int remaining, int current, int[] coins) {
        if (remaining < 0 || current < 0) {
            return 0;
        } else if (remaining == 0) {
            dp[remaining][current] = 1;
            return 1;
        } else {
            if (dp[remaining][current] != null) {
                return dp[remaining][current];
            } else {
                dp[remaining][current] = changeDFS(remaining - coins[current], current, coins) + changeDFS(remaining, current - 1, coins);
                return dp[remaining][current];
            }
        }
    }

    public int change2(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length]; // dp[i][j]: numbers of way to make up amount = i with only first j types of coins
        // i == 0
        Arrays.fill(dp[0], 1);
        // j == 0
        for(int i = 1; i <= amount; i++) {
            dp[i][0] = (i < coins[0]) ? 0 : dp[i - coins[0]][0];
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < coins.length; j++) {
                dp[i][j] = dp[i][j-1] + ( (i < coins[j]) ? 0 : dp[i - coins[j]][j] );
            }
        }

        return dp[amount][coins.length-1];
    }
}

// dp  0   1   2   3   4   5
//     1   1

// 1 2 5
// dp[1] = dp[0](1) = 1
// dp[2] = dp[0](2) + dp[1](1, 1) = 2
// dp[3] = dp[2]((2, 1), (1, 1, 1)) + dp[1](1, 2)) = 3 // duplicated