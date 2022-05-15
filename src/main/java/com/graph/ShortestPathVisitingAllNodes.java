package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    // https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/

    // allow revisit old node
    // not allow 1->0->1->0
    public int shortestPathLength(int[][] graph) {
        int counter = 0;

        Queue<int[]> queue = new LinkedList<>();
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        boolean seen[][] = new boolean[n][fullMask + 1];

        for(int i = 0; i < n; i++) {
            queue.offer(new int[]{i, nextMask(0, i)});
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] node = queue.poll();
                int mask = node[1];
                int cur = node[0];
                if (mask == fullMask) return counter;

                for(int i = 0; i < graph[cur].length; i++) {
                    int next = nextMask(mask, graph[cur][i]);
                    if (!seen[graph[cur][i]][next]) {
                        seen[graph[cur][i]][next] = true;
                        queue.offer(new int[]{graph[cur][i], nextMask(mask, graph[cur][i])});
                    }
                }
                size--;
            }
            counter++;
        }

        return -1;
    }

    private int nextMask(int cur, int i) {
        return cur | (1 << i);
    }
}
