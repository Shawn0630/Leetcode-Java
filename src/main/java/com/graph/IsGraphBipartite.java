package com.graph;

public class IsGraphBipartite {
    // https://leetcode.com/problems/is-graph-bipartite/discuss/1065709/C%2B%2B-or-DFS-or-O(n)-8ms-Beats-100-or-Explanation
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;

        UnionFind unionFind = new UnionFind(size);

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                if(unionFind.find(i) == unionFind.find(graph[i][j]))
                    return false;
                unionFind.union(graph[i][0], graph[i][j]);
            }
        }

        return true;

    }
    // [[1,3],[0,2],[1,3],[0,2]]

    //  0   ->  1
    //  0   ->  3

    //  1   ->  0
    //  1   ->  2

    //  2   ->  1
    //  2   ->  3

    //  3   ->  0
    //  3   ->  2
    public class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int size) {
            parent = new int[size];
            this.size = new int[size];

            for(int i = 0; i < size; i++) {
                this.size[i] = 1;
                this.parent[i] = i;
            }
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) {
                return false;
            }

            if (size[pi] <= size[pj]) {
                parent[pi] = pj;
                size[pj] += size[pi];
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }

            return true;
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }

            parent[i] = find(parent[i]);
            return parent[i];
        }
    }
}
