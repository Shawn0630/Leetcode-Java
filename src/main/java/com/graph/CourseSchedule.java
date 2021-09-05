package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // https://leetcode.com/problems/course-schedule/discuss/1435357/Java-BFS-Kahns-Algorithm-solution
        if (numCourses == 0 || prerequisites == null) {
            return false;
        }
        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            neighbours.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            neighbours.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> key : neighbours.entrySet()) {
            for(Integer neighbour : key.getValue()) {
                indegree[neighbour]++;
            }
        }
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;
            for (Integer neighbour : neighbours.get(cur)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}
