package com.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BrokenCalculator {
    // BFS LTE

    // *2, -1, *2, -1 trend
    // a = a * 2 increase
    // a = a - 1 decrease
    public int brokenCalc(int startValue, int target) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startValue);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curs = new ArrayList<>();
            while (size > 0) {
                curs.add(queue.poll());
                size--;
            }

            for(Integer cur : curs) {
                if (cur == target) return step;
                queue.offer(cur * 2);
                queue.offer(cur - 1);
            }

            step++;
        }

        return -1;
    }

    public int brokenCalc2(int startValue, int target) {
        if (startValue >= target) {
            return startValue - target;
        }

        // always greedy / 2
        int step = 0;
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target += 1;
            }
            step++;
        }

        return step + (startValue - target);
    }

}
