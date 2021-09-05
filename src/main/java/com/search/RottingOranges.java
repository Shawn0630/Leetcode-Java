package com.search;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    //https://leetcode.com/problems/rotting-oranges/discuss/1421324/Java-or-BFS-solution-with-explanations
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        Queue<Integer[]> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Integer[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int time = cur[2];

            result = Math.max(result, time);
            bfs(curX - 1, curY, grid, queue, time + 1);
            bfs(curX, curY - 1, grid, queue, time + 1);
            bfs(curX + 1, curY, grid, queue, time + 1);
            bfs(curX, curY + 1, grid, queue, time + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }

    private void bfs(int curX, int curY, int[][] grid, Queue<Integer[]> queue, int time) {
        if (curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length) {
            if (grid[curX][curY] == 1) {
                grid[curX][curY] = 2;
                queue.add(new Integer[]{curX, curY, time});
            }
        }
    }
}
