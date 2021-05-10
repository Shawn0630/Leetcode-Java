package com.stack;

import java.util.Stack;

public class TrappingRainWater {
    // referring to https://cloud.tencent.com/developer/article/1660100
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int top = stack.peek();
                stack.pop();

                if (!stack.empty()) {
                    int distance = i - stack.peek() - 1;
                    int h = Math.min(height[stack.peek()], height[i]) - height[top];
                    ans += distance * h;
                }
            }
            stack.push(i);
        }

        return ans;
    }
}
