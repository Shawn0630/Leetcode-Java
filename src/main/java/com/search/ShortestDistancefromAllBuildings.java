package com.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestDistancefromAllBuildings {

    // 0: empty
    // 1: building
    // 2: obstacle
    // 3: canReach
    public int shortestDistance(int[][] grid) {
        Set<int[]> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    set.add(new int[]{i, j});
                    dfs(grid, i, j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 3) {
                    int sum = 0;
                    for(int[] house : set) {
                        sum += Math.abs(house[0] - i) + Math.abs(house[1] - j);
                    }
                    min = Math.min(min, sum);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(int[][] grid, int row, int col) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow >= 0 && nextRow < grid.length &&
                nextCol >= 9 && nextCol < grid[0].length) {
                if (grid[nextRow][nextCol] == 0) {
                    grid[nextRow][nextCol] = 3;
                    dfs(grid, nextRow, nextCol);
                }
            }
        }
    }

    public int shortestDistance2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int totalHouse = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    totalHouse++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, bfs(grid, i, j, totalHouse));
                }
            }
        }


        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // 0 2 0     3 2 0      3 2 0     3
    // 0 2 1  => 0 2 1  =>  3 2 1 =>  3
    // 0 0 0     0 0 0      0 0 0     3
    private int bfs(int[][] grid, int row, int col, int totalHouse) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int foundHouse = 0;
        int step = 0;
        int distance = 0;

        while (!queue.isEmpty() && foundHouse < totalHouse) {
            for(int i = queue.size() - 1; i >=0; i--) {
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curCol = cur[1];

                if (grid[curRow][curCol] == 1) {
                    foundHouse++;
                    distance += step;
                    continue;
                }

                for(int[] dir : dirs) {
                    int nextRow = curRow + dir[0];
                    int nextCol = curCol + dir[1];

                    if (nextRow >= 0 && nextRow < grid.length &&
                        nextCol >= 0 && nextCol < grid[0].length) {
                        if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                            visited[nextRow][nextCol] = true;
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }

            }

            step++;
        }

        if (foundHouse != totalHouse) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if (visited[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }

            return Integer.MAX_VALUE;
        }

        return distance;
    }

    public static void main(String[] args) {
        ShortestDistancefromAllBuildings shortestDistancefromAllBuildings = new ShortestDistancefromAllBuildings();
        shortestDistancefromAllBuildings.shortestDistance2(new int[][]{{1,2,0}});
    }
}
