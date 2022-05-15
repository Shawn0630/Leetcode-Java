package com.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);

            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, values[i]);

            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1.0 / values[i]);
        }

        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = calDFS(query.get(0), query.get(1), new HashSet<>(), map);
        }

        return result;
    }

    // a / b = 0.5
    // b / a = 0.5 / 0.5 = 1
    // a / a = 1

    // https://leetcode.com/problems/evaluate-division/discuss/1992891/java-oror-DFS-Solution-with-comments-oror-Evaluate-Division-%3A)
    private double calDFS(String start, String end, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (!map.containsKey(start)) {
            return -1.0;
        }

        if (start.equals(end)) {
            return 1.0;
        }
        if (map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }

        Map<String, Double> neighbours = map.get(start);
        visited.add(start);

        for(Map.Entry<String, Double> neighbour : neighbours.entrySet()) {
            String next = neighbour.getKey();
            Double value = neighbour.getValue();

            if (!visited.contains(next)) {
                double result = calDFS(next, end, visited, map);

                if (result != -1.0) {
                    return value * result;
                }
            }

        }

        return -1.0;
    }
}
