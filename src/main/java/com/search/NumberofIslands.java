package com.search;

public class NumberofIslands {
    // '1's (land) and '0's (water), '2' visited
    public int numIslands(char[][] grid) {
        int counter = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    dfsIsland(i, j, grid);
                }
            }
        }

        return counter;
    }

    private void dfsIsland(int i, int j, char[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        grid[i][j] = '2';

        for(int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            if (nextI >= 0 && nextI < grid.length &&
                nextJ >= 0 && nextJ < grid[0].length &&
                grid[nextI][nextJ] == '1') {
                dfsIsland(nextI, nextJ, grid);
            }
        }
    }

    public int numIslands2(char[][] grid) {
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    searchForLand(grid, i, j);
                }
            }
        }

        return counter;
    }

    private void searchForLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == '0') return;

        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                searchForLand(grid, nextI, nextJ);
            }
        }
    }
}
