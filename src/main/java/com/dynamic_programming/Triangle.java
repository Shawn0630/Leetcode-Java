package com.dynamic_programming;

import java.util.List;

public class Triangle {
    //          2
    //      3       4
    //    6     5       7
    //  4   1       8       3
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        for(int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
