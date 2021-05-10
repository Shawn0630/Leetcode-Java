package com.stack;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || popped.length == 0 ||
                pushed.length != popped.length) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int pop_cur = 0;

        for(int push : pushed) {
            stack.push(push);
            while(!stack.empty() && stack.peek() == popped[pop_cur]) {
                pop_cur++;
                stack.pop();
            }
        }

        return pop_cur == popped.length;
    }
}
