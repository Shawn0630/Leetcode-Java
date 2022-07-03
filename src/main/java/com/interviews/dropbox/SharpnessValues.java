package com.interviews.dropbox;

import java.util.Arrays;

public class SharpnessValues {

    // 5    7   2
    // 7    5   8
    // 9    1   5

    // Ans: 7

    Integer dp[][];
    public int sharpnessValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n];

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            ans = Math.max(ans, sharpnessValue(grid, i, n - 1));
        }

        return ans;
    }

    private int sharpnessValue(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length ||
            y < 0 || y >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        int cur = grid[x][y];

        int left = sharpnessValue(grid, x, y - 1); // left
        int leftUP = sharpnessValue(grid, x + 1, y - 1); // left, up
        int leftBottom = sharpnessValue(grid, x - 1, y - 1); // left, bottom

        dp[x][y] = y == 0? cur : Math.min(cur, Math.max(left, Math.max(leftUP, leftBottom)));

        return dp[x][y];
    }

    // left should be computed

    public int sharpnessValueDP(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            dp[i][0] = grid[i][0];
        }

        for(int j = 1; j < n; j++) {
            for(int i = 0; i < m; i++) {
                int cur = grid[i][j];

                int left = dp[i][j - 1];
                int leftUP = i + 1 < m ? dp[i + 1][j - 1] : Integer.MIN_VALUE;
                int leftBottom = i - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MIN_VALUE;

                dp[i][j] = Math.min(cur, Math.max(left, Math.max(leftUP, leftBottom)));
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[i][n - 1]);
        }

        return ans;
    }

    public int sharpnessValueDPSpaceOptimised(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m];

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            dp[i] = grid[i][0];
            if (n == 1) {
                ans = Math.max(ans, dp[i]);
            }
        }


        for(int j = 1; j < n; j++) {
            int prev = dp[0];
            for(int i = 0; i < m; i++) {
                int cur = grid[i][j];

                int left = prev;
                int leftUp = i + 1 < m ? dp[i + 1] : Integer.MIN_VALUE;
                int leftBottom = i - 1 >= 0 ? dp[i - 1] : Integer.MIN_VALUE;

                prev = dp[i];
                dp[i] = Math.min(cur, Math.max(left, Math.max(leftUp, leftBottom)));

                if (j == n - 1) {
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }

    private int[] sharpnessValueDPArray(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new int[]{};
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m];

        for(int i = 0; i < m; i++) {
            dp[i] = grid[i][0];
        }


        for(int j = 1; j < n; j++) {
            int prev = dp[1];
            for(int i = 1; i < m - 1; i++) {
                int cur = grid[i][j];

                int left = prev;
                int leftUp = dp[i + 1];
                int leftBottom = dp[i - 1];

                prev = dp[i];
                dp[i] = Math.min(cur, Math.max(left, Math.max(leftUp, leftBottom)));
            }
        }

        return dp;
    }

    public int[][] extendedSubMatrix(int[][] grid, int startX, int endX, int startY, int endY) {
        int m = (endX + 1) - (startX - 1) + 1;
        int n = endY - startY + 1;
        int[][] ans = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int offsetX = startX - 1 + i;
                int offsetY = startY + j;

                if (offsetX < 0 || offsetX >= grid.length || offsetY < 0 || offsetY >= grid[0].length) {
                    ans[i][j] = Integer.MIN_VALUE;
                } else {
                    ans[i][j] = grid[offsetX][offsetY];
                }
            }
        }

        return ans;
    }

    public int sharpnessValueDivideConquer(int[][] grid) {
        int block = 2;

        int m = grid.length;
        int n = grid[0].length;
        int idx = 0;
        int[][] newGrid = new int[n][m];
        for(int j = 0; j < n; j = j + block) {
            newGrid[idx++] = sharpnessValueDPArray(extendedSubMatrix(grid, 0, grid.length - 1, j, Math.min(j + block - 1, n - 1)));
        }

        int[] dp = sharpnessValueDPArray(transpose(Arrays.copyOf(newGrid, idx)));

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private int[][] transpose(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newGrid[i][j] = grid[j][i];
            }
        }

        return newGrid;
    }

    public static void main(String[] args) {
        SharpnessValues sharpnessValues = new SharpnessValues();

        int[][] grid = new int[][] {
                {5, 7, 2},
                {7, 5, 8},
                {9, 1, 5}
        };

        System.out.println(sharpnessValues.sharpnessValue(grid));
    }
}
