package com.interviews.dropbox;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int counter = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                }
            }
        }
        UnionFind unionFind = new UnionFind(m * n, counter);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == '1') {
                            unionFind.union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }

        return unionFind.getCounter();

    }

    private class UnionFind {
        int[] parents;
        int[] sizes;
        int counter;

        public UnionFind(int size, int counter) {
            parents = new int[size];
            sizes = new int[size];

            for(int i = 0; i < size; i++) {
                sizes[i] = 1;
                parents[i] = i;
            }
            this.counter = counter;
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) {
                return false;
            }

            if (sizes[pi] >= sizes[pj]) {
                parents[pj] = pi;
                sizes[pi] += sizes[pj];
            } else {
                parents[pi] = pj;
                sizes[pj] += sizes[pi];
            }
            counter--;

            return true;
        }

        public int find(int i) {
            if (parents[i] == i) {
                return i;
            }

            parents[i] = find(parents[i]);

            return parents[i];
        }

        public int getCounter() {
            return this.counter;
        }
    }
}
