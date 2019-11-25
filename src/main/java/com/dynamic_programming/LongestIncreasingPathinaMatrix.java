package com.dynamic_programming;

public class LongestIncreasingPathinaMatrix {
    private int[][] dp;
    private int[][] matrix;
    private int ans = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dfs(i, j);
            }
        }

        return ans;
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        dp[i][j] = 1;
        if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(i - 1, j));
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] < matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(i + 1, j));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(i, j - 1));
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] < matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(i, j + 1));
        }

        ans = Math.max(ans, dp[i][j]);

        return dp[i][j];
    }
}
