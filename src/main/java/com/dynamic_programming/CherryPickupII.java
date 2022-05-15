package com.dynamic_programming;

public class CherryPickupII {
    //[[3(a),  1,  1(b)],
    // [2,     5,  1],
    // [1,     5,  5],
    // [2,     1,  1]]

    // assumptions/constraints
    // 1. no empty or null grid
    // https://leetcode.com/problems/cherry-pickup-ii/discuss/977843/Java-DP-Solution-with-video-explanations
    public int cherryPickup(int[][] grid) { // wrong, the ending pos matters, greedy, each row cannot use the same status to define next step.
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] dp = new int[grid.length]; //0: a as master, b as master, master means the first robot to take action
        int curA = 0;
        int curB = grid[0].length - 1;
        int[] dirs = new int[] {-1, 0, 1};

        dp[0] = grid[0][curA] + grid[0][curB];

        for(int i = 1; i < grid.length; i++) {
            int maxA = -1;
            int maxB = -1;
            int curMax = Integer.MIN_VALUE;
            int cache = 0;
            for(int dirA : dirs) {
                int nextA = curA + dirA;
                if (nextA < 0 || nextA >= grid[0].length) continue;
                int cur = dp[i - 1] + grid[i][nextA];
                cache = grid[i][nextA];
                grid[i][nextA] = 0;

                for(int dirB : dirs) {
                    int nextB = curB + dirB;
                    if (nextB < 0 || nextB >= grid[0].length) continue;
                    int sum = cur + grid[i][nextB];
                    if (sum > curMax) {
                        curMax = sum;
                        maxA = nextA;
                        maxB = nextB;
                    }
                }
                grid[i][nextA] = cache;
            }

            for(int dirB : dirs) {
                int nextB = curB + dirB;
                if (nextB < 0 || nextB >= grid[0].length) continue;
                int cur = dp[i - 1] + grid[i][nextB];
                cache = grid[i][nextB];
                grid[i][nextB] = 0;

                for(int dirA : dirs) {
                    int nextA = curA + dirA;
                    if (nextA < 0 || nextA >= grid[0].length) continue;
                    int sum = cur + grid[i][nextA];
                    if (sum > curMax) {
                        curMax = sum;
                        maxA = nextA;
                        maxB = nextB;
                    }
                }
                grid[i][nextB] = cache;
            }

            curA = maxA;
            curB = maxB;
            dp[i] = curMax;
        }

        return dp[grid.length - 1];
    }

    Integer[][][] dp;
    public int cherryPickup2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        dp = new Integer[grid.length][grid[0].length][grid[0].length];

        return cherryPickup2DFS(grid, 0, 0, grid[0].length - 1);
    }

    private int cherryPickup2DFS(int[][] grid, int row, int col1, int col2) {
        if (row >= grid.length || col1 < 0 || col1 >= grid[0].length ||
            col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }

        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }
        int result = 0;
        result += grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }

        int max = Integer.MIN_VALUE;
        for(int i = col1 - 1; i <= col1 + 1; i++) {
            for(int j = col2 - 1; j <= col2 + 1; j++) {
                max = Math.max(max, result + cherryPickup2DFS(grid, row + 1, i, j));
            }
        }

        dp[row][col1][col2] = max;
        return dp[row][col1][col2];
    }

    public static void main(String[] args) {
        CherryPickupII cherryPickupII = new CherryPickupII();
        cherryPickupII.cherryPickup(new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}});
    }
}
