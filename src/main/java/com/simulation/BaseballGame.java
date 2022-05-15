package com.simulation;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        for(String op : ops) {
            if ("C".equals(op)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("D".equals(op)) {
                if (!stack.isEmpty()) {
                    int value = stack.peek();
                    stack.push(2 * value);
                }
            } else if ("+".equals(op)) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.peek();

                    stack.push(first);
                    stack.push(first + second);
                }
            } else {
                int value = Integer.parseInt(op);
                stack.push(value);
            }
        }

        int ans = 0;

        while (!stack.empty()) {
            ans += stack.pop();
        }

        return ans;

    }
}
