package com.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] ans = new int[2 * nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2 * (nums.length - 1); i >= 0; i--) {
            while(!stack.empty() && stack.peek() <= nums[i % nums.length]) stack.pop();
            ans[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }

        return  Arrays.copyOfRange(ans, 0, nums.length);
    }
}
