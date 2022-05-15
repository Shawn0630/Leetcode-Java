package com.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public int orangesRotting2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int step = 0;

        while (!queue.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            boolean rotted = false;
            while(!queue.isEmpty()) list.add(queue.poll());
            for(int[] pos : list) {
                for(int[] dir : dirs) {
                    int nextX = pos[0] + dir[0];
                    int nextY = pos[1] + dir[1];
                    if (nextX >= 0 && nextX < grid.length &&
                        nextY >=0 && nextY < grid[0].length &&
                        grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        rotted = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

            if (rotted) step++;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return step;
    }
}
