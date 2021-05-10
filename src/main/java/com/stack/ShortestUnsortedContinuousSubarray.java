package com.stack;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
    // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int left = nums.length - 1;
        int right = 0;

        for(int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();

        for(int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }

        return left > right ? 0 : right - left + 1;
    }
}
