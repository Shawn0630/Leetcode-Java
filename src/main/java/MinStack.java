import java.util.Stack;

class MinStack {

//    Stack<Integer> stack;
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        if (stack.empty()) {
//            return Integer.MAX_VALUE;
//        }
//
//        int top = this.top();
//        this.pop();
//        int min = this.getMin();
//        this.push(top);
//        if (top < min) {
//            return this.top();
//        } else {
//            return min;
//        }
//
//    }

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    // stack: 3 1 5
    // minStack: 3 1

    public void pop() {
        int top = stack.peek();
        stack.pop();

        if (!minStack.empty() && minStack.peek() == top) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */