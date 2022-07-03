package com.interviews.dropbox;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslandsII {

//    public List<Integer> numIsLands2(int m, int n, int[][] positions) {
//        UnionFind unionFind = new UnionFind(m * n);
//
//        List<Integer> ans = new ArrayList<>();
//        int[][] grid = new int[m][n];
//
//        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        int numberOfIsland = 0;
//        for(int[] position : positions) {
//            int x = position[0];
//            int y = position[1];
//            grid[x][y] = 1;
//            numberOfIsland++;
//            for(int[] dir : dirs) {
//                int nx = x + dir[0];
//                int ny = y + dir[1];
//
//                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
//                    numberOfIsland = unionFind.union(x * n + y, nx * n + y, numberOfIsland);
//                }
//            }
//            ans.add(numberOfIsland);
//        }
//
//        return ans;
//    }
//
//    private class UnionFind {
//        int[] parents;
//        int[] sizes;
//
//        public UnionFind(int size) {
//            parents = new int[size];
//            sizes = new int[size];
//
//            for(int i = 0; i < size; i++) {
//                parents[i] = i;
//                sizes[i] = 1;
//            }
//        }
//
//        public int union(int i, int j, int numberOfIsland) {
//            int pi = find(i);
//            int pj = find(j);
//
//            if (pi == pj) {
//                return numberOfIsland;
//            }
//
//            numberOfIsland--;
//            if (sizes[pi] >= sizes[pj]) {
//                parents[pj] = pi;
//                sizes[pi] += sizes[pj];
//            } else {
//                parents[pi] = pj;
//                sizes[pj] += sizes[pi];
//            }
//
//            return numberOfIsland;
//
//        }
//
//        public int find(int i) {
//            if (parents[i] == i) {
//                return i;
//            }
//
//            parents[i] = find(parents[i]);
//            return parents[i];
//        }
//    }


    //  1   1   0
    //  0   0   1
    //  0   0   0
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind unionFind = new UnionFind(m * n);

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] grid = new int[m][n];

        int counter = 0;
        for(int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            if (grid[x][y] == 0) {
                counter++;
                grid[x][y] = 1;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {

                        counter = unionFind.union(x * n + y, nx * n + ny, counter);
                    }
                }
            }

            res.add(counter);
        }

        return res;

    }

    private class UnionFind {

        int[] parent;
        int[] sizes;
        int size;

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            this.sizes = new int[size];

            for(int i = 0; i < size; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }

        public int union(int x, int y, int islandCount) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return islandCount;
            }

            if (sizes[px] > sizes[py]) {
                parent[py] = px;
                sizes[px] += sizes[py];
            } else {
                parent[px] = py;
                sizes[py] += sizes[px];
            }

            return islandCount - 1;
        }

        private int find(int x) {
            if(parent[x] == x) {
                return x;
            }

            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}
