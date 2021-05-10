package com.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) {
            return 0;
        }
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.putIfAbsent(task, 0);
            taskCount.put(task, taskCount.get(task) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        taskCount.values().forEach(queue::offer);

        Map<Integer, Integer> coolDown = new HashMap<>();

        int currentTime = 0;
        while (!queue.isEmpty() || !coolDown.isEmpty()) {
            int release = currentTime - n - 1;
            if (coolDown.containsKey(release)) {
                queue.offer(coolDown.remove(release));
            }

            if (!queue.isEmpty()) {
                int taskLeft = queue.poll() - 1;
                if (taskLeft > 0) {
                    coolDown.put(currentTime, taskLeft);
                }
            }

            currentTime++;
        }

        return currentTime;
    }
}
