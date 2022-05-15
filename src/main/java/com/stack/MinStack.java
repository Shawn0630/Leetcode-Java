package com.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class MinStack {

    // https://leetcode.com/problems/min-stack/discuss/1539330/C%2B%2B-99.74-faster-or-Simple-Better-and-Optimal-solutions-using-stacks
    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (mins.isEmpty() || mins.peek() >= val) {
            mins.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (!mins.isEmpty() && val == mins.peek()) {
            mins.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
