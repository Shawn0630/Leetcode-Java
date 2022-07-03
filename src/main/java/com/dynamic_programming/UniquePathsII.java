package com.dynamic_programming;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }

        for(int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for(int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                if (obstacleGrid[i - 1][j] == 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    Integer[][] dp;
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new Integer[m][n];

        return uniquePathsWithObstacles2(obstacleGrid, m - 1, n - 1);
    }

    private int uniquePathsWithObstacles2(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        if (grid[x][y] == 1) {
            dp[x][y] = 0;
            return dp[x][y];
        }

        if (x == 0 && y == 0) {
            dp[x][y] = (grid[0][0] == 1 ? 0 : 1);
            return dp[x][y];
        }

        int sum = 0;
        sum += uniquePathsWithObstacles2(grid, x - 1, y);
        sum += uniquePathsWithObstacles2(grid, x, y - 1);

        dp[x][y] = sum;
        return dp[x][y];
    }



}
