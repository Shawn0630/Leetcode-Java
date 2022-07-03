package com.graph;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnectionsinaNetwork {
    // https://leetcode.com/problems/critical-connections-in-a-network/discuss/2049519/JAVA-BEATS-100.00-MEMORY-or-SPEED-0ms-or-APRIL-2022
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> connection : connections) {
            int source = connection.get(0);
            int target = connection.get(1);
            graph[source].add(target);
            graph[target].add(source);
        }


        // TODO
        return new ArrayList<>();

    }
}
