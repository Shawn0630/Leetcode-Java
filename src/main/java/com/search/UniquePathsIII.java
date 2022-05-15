package com.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    public int uniquePathsIIIBFS(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Queue<BSFNode> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int count = 0;
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) continue;
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    visited[i][j] = true;
                    queue.offer(new BSFNode(new int[]{i, j}, visited, 1));
                }
                count++;
            }
        }

        while (!queue.isEmpty()) {
            BSFNode bsfNode = queue.poll();
            int[] cur = bsfNode.pos;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < bsfNode.visited.length; i++) {
                visited[i] = Arrays.copyOf(bsfNode.visited[i], bsfNode.visited[i].length);
            }
            int curX = cur[0];
            int curY = cur[1];
            visited[curX][curY] = true;

            if (grid[curX][curY] == 2) {
                if (bsfNode.step == count) {
                    ans++;
                }
                continue;
            }

            for (int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if (nextX >= 0 && nextX < grid.length &&
                    nextY >= 0 && nextY < grid[0].length &&
                    grid[nextX][nextY] != -1 && !visited[nextX][nextY] ) {
                    queue.offer(new BSFNode(new int[]{nextX, nextY}, visited, bsfNode.step + 1));
                }
            }
        }

        return ans;
    }

    private class BSFNode {
        public int[] pos;
        public boolean[][] visited;
        public int step;

        public BSFNode(int[] pos, boolean[][] visited, int step) {
            this.pos = pos;
            this.visited = visited;
            this.step = step;
        }
    }


    public static void main(String[] arg) {
        UniquePathsIII up = new UniquePathsIII();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};

        up.uniquePathsIIIBFS(grid);

    }


    int counter = 0;
    public int uniquePathsIII2(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(i, j, visited, grid);
                }
            }
        }


        return counter;
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX >= 0 && nextX < visited.length &&
                nextY >= 0 && nextY < visited[0].length) {

                if (grid[nextX][nextY] == 2) {
                    visited[nextX][nextY] = true;
                    if (hasVisitedAll(visited, grid))
                    counter++;
                    continue;
                }

                if (grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, visited, grid);
                    visited[nextX][nextY] = false;
                }
            }
        }
    }

    private boolean hasVisitedAll(boolean[][] visited, int[][] grid) {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
