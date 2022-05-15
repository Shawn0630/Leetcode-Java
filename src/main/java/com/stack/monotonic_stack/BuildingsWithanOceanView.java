package com.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class BuildingsWithanOceanView {
    public int[] findBuildings(int[] heights) {
        int[] ans = new int[heights.length];
        int idx = 0;

        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterIndex = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) stack.pop();// stack.peek >= num[i]
            if (stack.isEmpty()) {
                nextGreaterIndex[i] = -1;
            } else {
                nextGreaterIndex[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i = 0; i < heights.length; i++) {
            if (nextGreaterIndex[i] == -1) {
                ans[idx++] = i;
            }
        }

        return Arrays.copyOf(ans, idx);
    }
}
