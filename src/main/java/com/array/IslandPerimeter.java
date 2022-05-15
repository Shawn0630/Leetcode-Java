package com.array;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int perimeter = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int a = 4;
                    for(int[] direction : directions) {
                        int ioff = direction[0];
                        int joff = direction[1];
                        if (i + ioff >= 0 && i + ioff < grid.length && j + joff >= 0 && j + joff < grid[0].length &&
                        grid[i + ioff][j + joff] == 1) {
                            a--;
                        }
                    }
                    perimeter += a;
                }
            }
        }

        return perimeter;
    }
}
