import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() throws Exception {
        if (stack.empty()) {
            throw new Exception("Empty Queue");
        } else if (stack.size() == 1) {
            return stack.pop();
        }

        int top = stack.peek();
        stack.pop();

        int item = this.pop();
        stack.push(top);

        return item;
    }

    /** Get the front element. */
    public int peek() throws Exception {
        if (stack.empty()) {
            throw new Exception("Empty Queue");
        } else if (stack.size() == 1) {
            return stack.peek();
        }

        int top = stack.peek();
        stack.pop();

        int item = this.peek();
        stack.push(top);

        return item;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}
