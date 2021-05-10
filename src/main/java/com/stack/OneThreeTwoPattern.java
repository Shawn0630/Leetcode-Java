package com.stack;

import java.util.Stack;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }


        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for(int i = 1; i < mins.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        // https://www.wandouip.com/t5i182393/
        // in stack as 2, nums[i] as 3, mins[i] as 1
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.empty() && stack.peek() < nums[i]) { // find the next num smaller than nums[i] as 2
                if (stack.pop() > mins[i]) {
                    return true;
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }

    public boolean find132pattern2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }


        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for(int i = 1; i < mins.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        // https://www.wandouip.com/t5i182393/
        // in stack as 3, nums[i] as 2, mins[i] as 1
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > mins[i]) {
                while (!stack.empty() && stack.peek() >= nums[i]) { // find the next num smaller than nums[i] as 2
                    stack.pop();
                }
                if (!stack.empty() && stack.peek() > mins[i]) {
                    return true;
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
