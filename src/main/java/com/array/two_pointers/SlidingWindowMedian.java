package com.array.two_pointers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    // Constraints
    // 1. k <= nums.length
    // 2. nums[i] range as int => use a long to hold result.
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b > a ? 1 : -1);


        double[] ans = new double[nums.length];
        int idx = 0;
        // 1, 2, 3, 4   k = 3  ans 4 - 3 + 1
        for(int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (max.peek() < nums[i - k]) {
                    min.remove(nums[i - k]);
                } else {
                    max.remove(nums[i - k]);
                }
            }

            if (!min.isEmpty() && nums[i] > min.peek()) {
                min.offer(nums[i]);
            } else {
                max.offer(nums[i]);
            }

            while (max.size() - min.size() > 1) {
                min.add(max.poll());
            }
            while (max.size() < min.size()) {
                max.add(min.poll());
            }

            if(i >= k - 1) {
                if (k % 2 == 0) {
                    ans[idx++] = ((double)min.peek() + (double)max.peek()) / 2;
                } else {
                    ans[idx++] = (double)(max.peek());
                }
            }
        }

        return Arrays.copyOf(ans, idx);
    }
}
