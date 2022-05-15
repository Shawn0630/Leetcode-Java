package com.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for(int num : stones) {
            queue.offer(num);
        }

        while (queue.size() >= 2) {
            int larger = queue.poll();
            int smaller = queue.poll();

            queue.offer(larger - smaller);
        } // queue.size() == 1;


        return queue.poll();
    }
}
