package com.graph;

import com.visualization.VisualizationUtils;
import org.algorithm_visualizer.Array1DTracer;
import org.algorithm_visualizer.Commander;
import org.algorithm_visualizer.GraphTracer;
import org.algorithm_visualizer.Layout;
import org.algorithm_visualizer.Tracer;
import org.algorithm_visualizer.VerticalLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {
    private static final GraphTracer graphTracer = new GraphTracer("course schedule");
    private static final Array1DTracer arrayTracer = new Array1DTracer("indegree");
    private static final Array1DTracer ansTracer = new Array1DTracer("ans");
    // https://leetcode.com/problems/course-schedule-ii/discuss/1385486/Java-2-Solutions%3A-BFS-Solution-and-DFS-Solution
    // https://leetcode.com/problems/course-schedule-ii/solution/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return new int[]{};
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        VisualizationUtils.configureGraphTracerByGraph(graphTracer, graph);
        graphTracer.directed(true);
        arrayTracer.set(indegree);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                list.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i : list) {
            if (dfs(i, indegree, graph, ans, numCourses)) return ans.stream().mapToInt(j -> j).toArray();
        }

        return new int[]{};
    }

    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        boolean[][] adj = new boolean[numCourses][numCourses];
        for(int[] pre : prerequisites) {
            adj[pre[1]][pre[0]] = true;
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < adj.length; i++) {
            for(int j = 0; j < adj.length; j++) {
                if (adj[i][j]) {
                    indegree[j]++;
                }
            }
        }

        int[] path = new int[numCourses];
        Set<Integer> visited = new HashSet<>();
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                visited.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            path[idx++] = cur;

            for(int i = 0; i < numCourses; i++) {
                if (adj[cur][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0 && !visited.contains(i)) {
                        queue.offer(i);
                    }
                }
            }
        }

        return idx == numCourses ? path : new int[]{};
    }

    int idx;
    public int[] findOrder4(int numCourses, int[][] prerequisites) {
        boolean[][] adj = new boolean[numCourses][numCourses];
        for(int[] pre : prerequisites) {
            adj[pre[1]][pre[0]] = true;
        }

        int[] path = new int[numCourses];
        idx = 0;
        int[] visited = new int[numCourses]; // 0: not visited, 1: visiting, 2: visited
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !findOrder4DFS(adj, i, path, numCourses, visited)) return new int[]{};
        }

        reverse(path);
        return path;
    }

    private void reverse(int[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
    }

    public boolean findOrder4DFS(boolean[][] adj, int cur, int[] path, int numCourse, int[] visited) {
        visited[cur] = 1;
        for(int i = 0; i < numCourse; i++) {
            if (adj[cur][i]) {
                if (visited[i] == 0) {
                    if (!findOrder4DFS(adj, i, path, numCourse, visited)) return false;
                } else if (visited[i] == 1) {
                    return false;//have loop
                }
            }
        }

        visited[cur] = 2;
        path[idx++] = cur;

        return true;
    }

    public static void main(String[] args) {
        Layout.setRoot(new VerticalLayout(new Commander[]{graphTracer, arrayTracer, ansTracer}));
        CourseScheduleII courseScheduleII = new CourseScheduleII();
//        int[] courses = courseScheduleII.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});

//          int[] courses = courseScheduleII.findOrder2(3, new int[][]        {{0,1},{0,2},{1,2}});
//          int[] courses = courseScheduleII.findOrder2(4, new int[][]{{1,0},{3,1},{3,2}});
//        int[] courses = courseScheduleII.findOrder(2, new int[][]{{1,0}});
        int[] courses = courseScheduleII.findOrder3(2, new int[][]{{0,1}});
//        int[] courses = courseScheduleII.findOrder(1, new int[][]{});
    }

    private boolean dfs(int cur, int[] indegree, Map<Integer, List<Integer>> graph, List<Integer> list, int numCourses) {
        graphTracer.select(cur);
        list.add(cur);
        ansTracer.set(list);
        arrayTracer.set(indegree);
        Tracer.delay();
        if (list.size() == numCourses) {
            return true;
        }

        List<Integer> nextCourses = graph.get(cur);
        for(int next : nextCourses) {
            indegree[next]--;
            if (indegree[next] == 0 && !list.contains(next)) {
                if (dfs(next, indegree, graph, list, numCourses)) return true;
            }
        }
        return false;
    }


    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courses = new HashMap<>();
        Queue<BFSNode> queue = new LinkedList<>();

        for(int [] pre : prerequisites) {
            courses.putIfAbsent(pre[0], new ArrayList<>());
            courses.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if (courses.get(i) == null) {
                List<Integer> path = new ArrayList<>();
                path.add(i);
                Set<Integer> visited = new HashSet<>();
                visited.add(i);
                queue.offer(new BFSNode(path, visited));
            }
        }

        while (!queue.isEmpty()) {
            List<BFSNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodes.add(queue.poll());
            }

            for(BFSNode node : nodes) {
                if(node.path.size() == numCourses) {
                    return node.path.stream().mapToInt(j -> j).toArray();
                } else {
                    for(int i = 0; i < numCourses; i++) {
                        if (canTake(courses.get(i), node.visited, i)) {
                            List<Integer> newPath = new ArrayList<>(node.path);
                            newPath.add(i);
                            Set<Integer> newSet = new HashSet<>(node.visited);
                            newSet.add(i);
                            queue.offer(new BFSNode(newPath, newSet));
                        }
                    }
                }
            }
        }


        return new int[]{};
    }

    private boolean canTake(List<Integer> pres, Set<Integer> visited, int i) {
        if (visited.contains(i)) {
            return false; // already token
        }
        if (pres != null) {
            for (Integer pre : pres) {
                if (!visited.contains(pre)) {
                    return false;
                }
            }
        }
        return true;
    }

    private class BFSNode {
        List<Integer> path;
        Set<Integer> visited;

        public BFSNode(List<Integer> path, Set<Integer> visited) {
            this.path = path;
            this.visited = visited;
        }
    }
}
