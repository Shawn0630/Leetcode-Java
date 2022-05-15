package com.graph.union_find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    // 0 - non occupied
    // 1 - occupied
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Map<Integer, Integer> colorSize;
    public int largestIsland(int[][] grid) {
        colorSize = new HashMap<>(); // color => component size

        int color = 2;

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    paint(i, j, grid, color);
                    ans = Math.max(ans, colorSize.get(color));
                    color++;
                }
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> colors = new HashSet<>();
                    for(int[] dir : dirs) {
                        int nextX = i + dir[0];
                        int nextY = j + dir[1];

                        if (nextX >= 0 && nextX < grid.length &&
                                nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] != 0) {
                            color = grid[nextX][nextY];
                            colors.add(color);
                        }
                    }

                    int component = 1;
                    for(Integer c : colors) {
                        component += colorSize.get(c);
                    }

                    ans = Math.max(component, ans);
                }
            }
        }

        return ans;
    }


    private void paint(int x, int y, int[][] grid, int color) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }

        grid[x][y] = color;
        colorSize.put(color, colorSize.getOrDefault(color, 0) + 1);

        for(int[] dir :dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            paint(nextX, nextY, grid, color);
        }
    }

    public int largestIsland2(int[][] grid) {

        UnionFind unionFind = new UnionFind(grid.length * grid[0].length);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
//                    unionFind.add(i * grid[0].length + j);
                    for(int[] dir : dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];

                        if (nextI >= 0 && nextI < grid.length &&
                            nextJ >= 0 && nextJ < grid.length && grid[nextI][nextJ] == 1) {
                            unionFind.union(i * grid[0].length + j, nextI * grid[0].length + nextJ);
                        }
                    }
                    int parent = unionFind.find(i * grid[0].length + j);
                    ans = Math.max(ans, unionFind.size[parent]);
                }
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
//                    unionFind.add(i * grid[0].length + j);
                    Set<Integer> parents = new HashSet<>();
                    for(int[] dir : dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];

                        if (nextI >= 0 && nextI < grid.length &&
                                nextJ >= 0 && nextJ < grid.length && grid[nextI][nextJ] == 1) {
                            parents.add(unionFind.find(nextI * grid[0].length + nextJ));
                        }
                    }
                    int curAns = 1;
                    for(int parent : parents) {
                        if (parent != -1) {
                            curAns += unionFind.size[parent];
                        }
                    }
                    ans = Math.max(ans, curAns);
                }
            }
        }

        return ans;
    }


    private class UnionFind {

        int[] parent;
        int[] size;
        public UnionFind(int size) {
            this.parent = new int[size];
            Arrays.fill(parent, -1);
            this.size = new int[size];

            for(int i = 0; i < size; i++) {
                parent[i] = i;
                this.size[i] = 1;
            }
        }

//        public void add(int i) { // need as there is some disconnected nodes.
//            if (parent[i] != -1) {
//                return;
//            }
//
//            parent[i] = i;
//            size[i] = 1;
//        }

        public int find(int i) {
            if (parent[i] == i) return i;
            parent[i] = find(parent[i]); // path compression
            return parent[i];
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) return false; // no need to merge two component

            if (size[pi] <= size[pj]) {  // Merge the smaller component to the bigger component
                parent[pi] = pj;
                size[pj] += size[pi];
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }

            return true;
        }
    }

    // [[1,0],
    //  [0,1]]

    // 3
    Map<Integer, Integer> colors;
    public int largestIsland3(int[][] grid) {
        int color = 2;
        Map<Integer, Integer> map = new HashMap<>();
        colors = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) { // unoccupied
                    dfs(grid, i, j, color);
                    ans = Math.max(ans, colors.get(color));
                    color++;
                }
            }
        }


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> selectedColor = new HashSet<>();
                    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                    int sum = 1;
                    for(int[] dir : dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];

                        if (nextI >= 0 && nextI < grid.length &&
                            nextJ >= 0 && nextJ < grid[0].length) {
                            if (grid[nextI][nextJ] != 0 && !selectedColor.contains(grid[nextI][nextJ])) {
                                sum += colors.get(grid[nextI][nextJ]);
                                selectedColor.add(grid[nextI][nextJ]);
                            }
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int color) {
        grid[x][y] = color;

        colors.put(color, colors.getOrDefault(color, 0) + 1);


        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX >= 0 && nextX < grid.length &&
                nextY >= 0 && nextY < grid[0].length) {
                if (grid[nextX][nextY] == 1) {
                    dfs(grid, nextX, nextY, color);
                }
            }
        }
    }
}
