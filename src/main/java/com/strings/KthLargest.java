package com.strings;

import java.util.PriorityQueue;

public class KthLargest {
    int capacity;
    PriorityQueue<Integer> queue;
    // 4, 5, 8, 2
    // 4 -> 4, 5 -> 4, 5, 8 -> 2, 4, 5
    // 4 -> 5, 4 -> 8, 5, 4 -> ...
    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        this.queue = new PriorityQueue<>();
        for(int num : nums) {
            queue.offer(num);
            if (queue.size() > capacity) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);


        if (queue.size() > capacity) {
            queue.poll();

        }
            return queue.peek();
    }
}
