package com.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    // https://leetcode.com/problems/jump-game-iii/discuss/1400025/JAVAor-Both-DFS-and-BFS-Method-Solution
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length <= start) {
            return false;
        }

        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            visited[cur] = true;
            if (cur - arr[cur] >= 0 && !visited[cur - arr[cur]]) {
                queue.add(cur - arr[cur]);
            }
            if (cur + arr[cur] < arr.length && !visited[cur + arr[cur]]) {
                queue.add(cur + arr[cur]);
            }
        }

        boolean canReach = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && visited[i]) {
                canReach = true;
            }
        }

        return canReach;
    }

    public boolean canReachDFS(int[] arr, int start) {
        for(int i = 0; i < arr.length; i++) {
            if (i != start && arr[i] == 0) {
                if (!canReachDFS(arr, start, i, new HashSet<>())) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean canReachDFS(int[] arr, int start, int end, Set<Integer> set) {
        if (start == end) {
            return true;
        }
        set.add(start);

        return (start + arr[start] < arr.length && !set.contains(start + arr[start]) && canReachDFS(arr, start + arr[start], end, set)) ||
                (start - arr[start] >= 0 && !set.contains(start - arr[start]) && canReachDFS(arr, start - arr[start], end, set));
    }

}
