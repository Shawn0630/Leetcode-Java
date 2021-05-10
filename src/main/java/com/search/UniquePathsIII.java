package com.search;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int zero = 0;
        int startX = -1;
        int startY = -1;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        return dfs(grid, startX, startY, zero);
    }


    private int dfs(int[][] grid, int curX, int curY, int zero) {
        if (curX < 0 || curY < 0 || curX >= grid.length || curY >= grid[0].length || grid[curX][curY] == -1) {
            return 0;
        } else if (grid[curX][curY] == 2) {
            return zero == -1 ? 1 : 0;
        } else {
            grid[curX][curY] = -1;
            zero--;
            int total = dfs(grid, curX + 1, curY, zero) + dfs(grid, curX -1, curY, zero) + dfs(grid, curX, curY + 1, zero) + dfs(grid, curX, curY - 1, zero);
            grid[curX][curY] = 0;
            return total;
        }
    }
}
