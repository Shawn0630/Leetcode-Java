package com.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur >= low && cur <= high) result.add(cur);
            int lastDigit = cur % 10;
            int next = cur * 10 + lastDigit + 1;
            if (lastDigit < 9 && next <= high) queue.add(next);
        }

        return result;
    }
}
