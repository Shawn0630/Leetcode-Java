package com.array;

import java.util.PriorityQueue;

public class MinimizeDeviationinArray {
    // even / 2
    // odd * 2

    // 1,2,3,2
    // 1, 3
    // 2

    // deviation = max - min
    // first increase then decrease

    // two ways, decrease max or increase min
    // You can perform two types of operations on any element of the array any number of times:
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int minimum = Integer.MAX_VALUE;
        for(int num : nums) {
            if (num % 2 == 0) {
                heap.offer(num);
                minimum = Math.min(minimum, num);
            } else {
                heap.offer(num * 2);
                minimum = Math.min(minimum, num * 2);
            }
        }

        int minDeviation = Integer.MAX_VALUE;
        while (!heap.isEmpty()) {
            int current = heap.poll();
            minDeviation = Math.min(minDeviation, current - minimum);
            if (current % 2 == 0) {
                heap.offer(current / 2);
                minimum = Math.min(minimum, current / 2);
            } else {
                break;
            }
        }

        return minDeviation;

    }
}
