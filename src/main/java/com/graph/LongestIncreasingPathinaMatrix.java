package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathinaMatrix {
    // https://leetcode.com/submissions/detail/688928346/
    int[][] longestEndingAt;
    int ans;
    public int longestIncreasingPath(int[][] matrix) {
        longestEndingAt = new int[matrix.length][matrix[0].length];
        ans = 1;

        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(longestEndingAt[i], 1);
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                bfs(i, j, matrix);
            }
        }

        return ans;
    }

    public int longestIncreasingPath2(int[][] matrix) {
        longestEndingAt = new int[matrix.length][matrix[0].length];
        ans = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(longestEndingAt[i], 0);
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int[] dir : dirs) {
                int nxtX = curX + dir[0];
                int nxtY = curY + dir[1];
                if (nxtX >= 0 && nxtX < matrix.length &&
                        nxtY >= 0 && nxtY < matrix[0].length &&
                        matrix[curX][curY] < matrix[nxtX][nxtY]) {
                    if (1 + longestEndingAt[curX][curY] > longestEndingAt[nxtX][nxtY]) {
                        longestEndingAt[nxtX][nxtY] = 1 + longestEndingAt[curX][curY];
                        ans = Math.max(longestEndingAt[nxtX][nxtY], ans);
                        queue.offer(new int[]{nxtX, nxtY});
                    }
                }
            }
        }

        return ans;
    }

    private void bfs(int x, int y, int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int[] dir : dirs) {
                int nxtX = curX + dir[0];
                int nxtY = curY + dir[1];
                if (nxtX >= 0 && nxtX < matrix.length &&
                    nxtY >= 0 && nxtY < matrix[0].length &&
                    matrix[curX][curY] < matrix[nxtX][nxtY]) {
                    if (1 + longestEndingAt[curX][curY] > longestEndingAt[nxtX][nxtY]) {
                        longestEndingAt[nxtX][nxtY] = 1 + longestEndingAt[curX][curY];
                        ans = Math.max(longestEndingAt[nxtX][nxtY], ans);
                        queue.offer(new int[]{nxtX, nxtY});
                    }
                }
            }
        }
    }
}
