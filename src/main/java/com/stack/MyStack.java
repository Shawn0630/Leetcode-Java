package com.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    //  1   2   3
    //  1 ->  1,2 =>2,1 => 2,1,3 => 3,2,1
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);

        int n = q.size();
        while (n-- > 1)
            q.add(q.poll());
    }

    // Removes the element on top of the stack.
    public int pop() {
        return q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
