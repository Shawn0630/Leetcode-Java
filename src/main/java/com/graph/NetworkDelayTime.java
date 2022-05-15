package com.graph;

import sun.nio.ch.Net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetworkDelayTime {
    //
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];

        for(int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int[] time : times) {
            int source = time[0];
            int target = time[1];
            int dist = time[2];

            graph[source][target] = dist;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);


        int[][] cost = new int[n + 1][n + 1];
        for(int i = 0; i < graph.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[k][k] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i = 0; i < graph.length; i++) {
                if (graph[cur][i] != Integer.MAX_VALUE) {
                    if (cost[k][cur] + graph[cur][i] < cost[k][i]) {
                        cost[k][i] = cost[k][cur] + graph[cur][i];
                        queue.offer(i);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < cost.length; i++) {
            if (cost[k][i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, cost[k][i]);
        }

        return max;
    }

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        networkDelayTime.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
    }
}
