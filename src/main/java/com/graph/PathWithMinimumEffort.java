package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort {

    // [[1,     2,      2],
    //  [3,     8,      2],
    //  [5,     3,      5]]

    // https://leetcode.com/problems/path-with-minimum-effort/discuss/1000195/Thought-Process-from-Naive-BFS-to-Dijkstra
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // four direction, DFS won't work
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
       int[][] cost = new int[m][n];

       for(int i = 0; i < m; i++) {
           Arrays.fill(cost[i], Integer.MAX_VALUE);
       }

       Queue<int[]> queue = new LinkedList<>(); // use linkedList as the queue.
       queue.offer(new int[]{0, 0});
       cost[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m &&
                    ny >= 0 && ny < n) {
                    int newCost = Math.max(cost[x][y], Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        queue.offer(new int[]{nx, ny});
                    }

                }
            }
        }

        return cost[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};

        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        pathWithMinimumEffort.minimumEffortPath(heights);
    }
}
