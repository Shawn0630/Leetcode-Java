package com.interviews.dropbox;

import java.util.Arrays;

public class SharpnessValues2 {
    // 5    7   2
    // 7    5   8
    // 9    1   5

    // Ans: 7

    // Fine the path from left to right which has the highest minimum sharpness
    Integer[][] dp;
    public int sharpnessValue(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];
        int sharpness = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            sharpness = Math.max(sharpness, sharpnessValue(grid, i, grid[0].length - 1));
        }

        return sharpness;
    }

    public int sharpnessValueDp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        int sharpness = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            dp[i][0] = grid[i][0];
            if (grid[0].length == 1) {
                sharpness = Math.max(sharpness, grid[i][0]);
            }
        }


        for(int j = 1; j < grid[0].length; j++) {
            for(int i = 0; i < grid.length; i++) {
                int left = dp[i][j - 1];
                int topLeft = i - 1 < 0 ? Integer.MIN_VALUE : dp[i - 1][j - 1];
                int downLeft = i + 1 >= grid.length ? Integer.MIN_VALUE : dp[i + 1][j - 1];
                dp[i][j] = Math.min(grid[i][j], Math.max(left, Math.max(topLeft, downLeft)));

                if(j == grid[0].length - 1) {
                    sharpness = Math.max(sharpness, dp[i][j]);
                }
            }
        }

        return sharpness;

    }

    public int sharpnessValueDpMem(int[][] grid) {
        int[] dp = new int[grid.length];

        int sharpness = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            dp[i] = grid[i][0];
            if (grid[0].length == 1) {
                sharpness = Math.max(sharpness, grid[i][0]);
            }
        }


        for(int j = 1; j < grid[0].length; j++) {
            int[] temp = Arrays.copyOf(dp, dp.length);
            for(int i = 0; i < grid.length; i++) {
                int left = temp[i];
                int topLeft = i - 1 < 0 ? Integer.MIN_VALUE : temp[i - 1];
                int downLeft = i + 1 >= grid.length ? Integer.MIN_VALUE : temp[i + 1];
                dp[i] = Math.min(grid[i][j], Math.max(left, Math.max(topLeft, downLeft)));

                if(j == grid[0].length - 1) {
                    sharpness = Math.max(sharpness, dp[i]);
                }
            }
        }

        return sharpness;
    }

    private int sharpnessValue(int[][] grid, int x, int y) {
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        if (y == 0) {
            dp[x][y] = grid[x][y];
            return dp[x][y];
        }
        int leftTop = x - 1 < 0 ? Integer.MIN_VALUE : sharpnessValue(grid, x - 1, y - 1);
        int left = sharpnessValue(grid, x, y - 1);
        int leftDown = x + 1 >= grid.length ? Integer.MIN_VALUE : sharpnessValue(grid, x + 1, y - 1);

        dp[x][y] = Math.min(Math.max(leftTop, Math.max(left, leftDown)), grid[x][y]);
        return dp[x][y];
    }


    public static void main(String args[]) {
        int[][] input = new int[][]{
                {5, 7, 2},
                {7, 5, 8},
                {9, 1, 5}
        };

        SharpnessValues2 sharpnessValues2 = new SharpnessValues2();
        System.out.println(sharpnessValues2.sharpnessValue(input));
        System.out.println(sharpnessValues2.sharpnessValueDp(input));
        System.out.println(sharpnessValues2.sharpnessValueDpMem(input));
    }
}
