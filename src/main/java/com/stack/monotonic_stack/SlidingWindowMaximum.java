package com.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SlidingWindowMaximum {
    //          1,      3,          -1,     -3,      5,      3,      6,      7
    //   1  =>  3, 1 => 3, 1, -1 => 3, -1, -3 => -1,
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int[] ans = new int[nums.length];

        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() >= k) {
                if (queue.size() > k) {
                    queue.remove(nums[i - k]);
                }
                ans[idx++] = queue.peek();
            }
        }

        return Arrays.copyOf(ans, idx);
    }
    //          1,      3,          -1,     -3,          5,      3,      6,      7
    // stack    1      3            3,-1   3, -1, -3
    // https://leetcode.com/problems/sliding-window-maximum/discuss/1380640/C%2B%2B-SIMPLE-with-EXPLANATION-Monotonic-Queue-O(n)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();

        int[] ans = new int[nums.length];

        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();// remove the smaller
            queue.offer(i);
            while (!queue.isEmpty() && nums[queue.peekFirst()] <= i - k) queue.pollFirst();
            if (!queue.isEmpty() && i >= k - 1) {
                ans[idx++] = nums[queue.peekFirst()];
            }

        }

        return Arrays.copyOf(ans, idx);
    }
}
