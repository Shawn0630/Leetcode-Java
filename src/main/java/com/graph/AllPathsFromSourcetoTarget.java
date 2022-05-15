package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AllPathsFromSourcetoTarget {
    Set<Integer> hasVisited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        hasVisited = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTargetDFS(graph, 0, ans, path);

        return ans;
    }

    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        Queue<QueueItem> queue = new LinkedList<>();

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        path.add(0);
        queue.offer(new QueueItem(0, path));

        while (!queue.isEmpty()) {
            QueueItem item = queue.poll();
            if (item.current == graph.length - 1) {
                ans.add(item.path);
            } else {
                for (int next : graph[item.current]) {
                    List<Integer> currentPath = new ArrayList<>(item.path);
                    currentPath.add(next);
                    queue.offer(new QueueItem(next, currentPath));
                }
            }
        }

        return ans;
    }

    private class QueueItem {
        int current;
        List<Integer> path;

        QueueItem(int current, List<Integer> path) {
            this.current = current;
            this.path = path;
        }
    }

    private void allPathsSourceTargetDFS(int[][] graph, int current, List<List<Integer>> ans, List<Integer> path) {
        if (current >= graph.length) {
            return;
        }

        if (current == graph.length - 1) {
            ans.add(new ArrayList<>(path));
        }

        for(int next : graph[current]) {
            if (!hasVisited.contains(next)) {
                hasVisited.add(next);
                path.add(next);
                allPathsSourceTargetDFS(graph, next, ans, path);
                hasVisited.remove(next);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourcetoTarget allPathsFromSourcetoTarget = new AllPathsFromSourcetoTarget();
        List<List<Integer>> ans = allPathsFromSourcetoTarget.allPathsSourceTarget(
                new int[][]{{4,3,1},{3,2,4},{},{4},{}});

        System.out.println(ans);
    }
}
