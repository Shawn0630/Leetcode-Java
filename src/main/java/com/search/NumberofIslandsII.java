package com.search;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        int color = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] position : positions) {
            grid[position[0]][position[1]] = color++;
            for(int[] dir : dirs) {
                int nextX = position[0] + dir[0];
                int nextY = position[1] + dir[1];

                if (nextX >= 0 && nextX < m &&
                    nextY >= 0 && nextY < n) {


                }
            }
        }

        return new ArrayList<>();
    }

    private class UnionFind {
        int[] size;
        int[] parent;

        public UnionFind(int maximum) {
            size = new int[maximum];
            parent = new int[maximum];

            for(int i = 0; i < maximum; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) return i;

            parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) return false;

            if(size[pi] <= size[pj]) {
                parent[pi] = pj;
                size[pj] += size[pi];
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }

            return true;
        }
    }
}
