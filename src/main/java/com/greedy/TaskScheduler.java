package com.greedy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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


    // assumption/constraints
    // 1. no empty array
    // 2. n >= 0
    // 3. only upper case letter
    // [A, A, B] 2
    // A  B  sleep A  --4
    // B  A  sleep sleep A --5
    // greedy
    //
    // https://leetcode.com/problems/task-scheduler/discuss/373231/Java-Easy-To-Understand-O(nlog(m))-time-O(m)-space-solution-with-explanation
    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();

        for(char task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }// [A, A, B] => [A = 2, B = 1]
        Queue<Pair<Character, Integer>> cooldowns = new LinkedList<>();
        PriorityQueue<Character> nextTasks = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));

        for(char key : count.keySet()) {
            nextTasks.offer(key);
        }//[A, B]

        int time = 0;

        // instead of tracking the last execution time, track the next available time slot
        while (!nextTasks.isEmpty() || !cooldowns.isEmpty()) {
            if(nextTasks.isEmpty()) time = cooldowns.peek().getValue();
            while (!cooldowns.isEmpty() && time >= cooldowns.peek().getValue()) {
                nextTasks.offer(cooldowns.poll().getKey());
            }
            // A A B  2
            // 0   1    2    3   => 4 - 1 =3
            // A   B  sleep   A
            if (!nextTasks.isEmpty()) {
                Character nextTask = nextTasks.poll();
                count.put(nextTask, count.get(nextTask) - 1);
                if (count.get(nextTask) != 0) { // have remaining task
                    cooldowns.offer(new Pair<>(nextTask, time + n + 1)); // A executes at 0, not until 3
                }
            }

            time++;
        }


        return time;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        taskScheduler.leastInterval2(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);
    }
}
