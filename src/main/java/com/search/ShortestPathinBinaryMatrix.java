package com.search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        boolean[][] hasUsed = new boolean[grid.length][grid[0].length];

        int[][] dirs = new int[][]{
                {0, -1},
                {0, 1},
                {1, -1},
                {1, 0},
                {1, 1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
        };

        Queue<Location> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.add(new Location(0, 0, 1));
            hasUsed[0][0] = true;
        }
        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            int curX = loc.x;
            int curY = loc.y;
            int step = loc.step;
            if (curX == grid.length - 1 && curY == grid[0].length -1) {
                return step;
            }

            for (int[] dir : dirs) {
                int dirX = dir[0];
                int dirY = dir[1];
                int nextX = curX + dirX;
                int nextY = curY + dirY;

                if (nextX >= 0 && nextX < grid.length &&
                        nextY >= 0 && nextY < grid[0].length &&
                        grid[nextX][nextY] == 0 && !hasUsed[nextX][nextY]) {
                    queue.add(new Location(nextX, nextY, step + 1));
                    hasUsed[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }

    private class Location {
        int x;
        int y;
        int step;

        Location(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
