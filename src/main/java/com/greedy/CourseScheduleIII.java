package com.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) {
            return 0;
        }

        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for(int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            if (time + duration <= lastDay) {
                queue.offer(duration);
                time += duration;
            } else if (!queue.isEmpty() && queue.peek() > duration) {
                time = time + duration - queue.poll();
                queue.offer(duration);
            }
        }

        return queue.size();
    }
}
