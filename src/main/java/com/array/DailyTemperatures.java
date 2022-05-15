package com.array;

import java.util.Stack;

public class DailyTemperatures {
    // https://leetcode.com/problems/daily-temperatures/discuss/1574831/Java-2-Simple-Approaches-or-Constant-space-or-Stack-or-Beats-100-or-TC%3A-O(N)-SC%3A-O(1)
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        int[] nextWarmer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            if (stack.empty()) {
                nextWarmer[i] = 0;
            } else {
                nextWarmer[i] = stack.peek() - i; // stack.peek() > temperature[i]
            }
            stack.push(i);
        }


        return nextWarmer;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
