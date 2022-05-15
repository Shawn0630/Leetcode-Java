package com.search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
    // https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/1486003/Java-or-BFS
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // three dimension
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        int[][] directions = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};

        Queue<Node> queue = new LinkedList<>();
//        if (grid[0][0] == 1 && k >= 1) {
//            queue.add(new Node(0, 0, k - 1, 0));
//        } else {
            queue.add(new Node(0, 0, k, 0));
//        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curX = cur.curX;
            int curY = cur.curY;
            int step = cur.step;
            int remaining = cur.remaining;

            if (curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length && remaining >= 0 &&!visited[curX][curY][remaining]) {
                visited[curX][curY][remaining] = true;
                if (grid[curX][curY] == 1) {
                    remaining--;
                }
                if (remaining >= 0) {
                    if (curX == grid.length - 1 && curY == grid[0].length - 1) {
                        return step;
                    }
                    queue.add(new Node(curX - 1, curY + 0, remaining, step + 1));
                    queue.add(new Node(curX + 1, curY + 0, remaining, step + 1));
                    queue.add(new Node(curX + 0, curY - 1, remaining, step + 1));
                    queue.add(new Node(curX + 0, curY + 1, remaining, step + 1));
                }
            }

//            visited[curX][curY] = true;
//            if (grid[curX][curY] == 1) {
//                remaining--;
//            }
//            if (remaining >= 0 && curX == grid.length - 1 && curY == grid[0].length - 1) {
//                return step;
//            }
//
//            for(int[] direction : directions) {
//                int nextX = curX + direction[0];
//                int nextY = curY + direction[1];
//                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && !visited[nextX][nextY] && remaining >= 0) {
//                    queue.add(new Node(nextX, nextY, remaining, step + 1));
//                }
//            }

        }

        return -1;
    }

    private class Node {
        int curX, curY, remaining, step;

        public Node(int curX, int curY, int remaining, int step) {
            this.curX = curX;
            this.curY = curY;
            this.remaining = remaining;
            this.step = step;
        }
    }
}
