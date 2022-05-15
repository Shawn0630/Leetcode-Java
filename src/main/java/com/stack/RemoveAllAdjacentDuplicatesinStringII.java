package com.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    //               d    e   e   e   d   b   b   c   c   c   b   d   a   a
    // stack         d => d1e1 => d1e1e2 => d1{e1e2e3} => d1b1 => d1b1b2 => d1b1b2c1=>d1b1b2c1c2=>d1b1b2{c1c2c3}=>d1{b1b2b3|
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.empty() && stack.peek().c == c) {
                if (stack.peek().count + 1 == k) {
                    int cur = k - 1;
                    while (cur > 0) {
                        stack.pop();
                        cur--;
                    }
                } else {
                    stack.push(new Node(c, stack.peek().count + 1));
                }
            } else {
                stack.push(new Node(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop().c);
        }

        return sb.toString();
    }

    private class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates2(String s, int k) {
        int[] count = new int[s.length()];
        char[] sarray = s.toCharArray();
        int idx = 0;

        for(int i = 0; i < s.length(); i++) {
            sarray[idx] = sarray[i];
            if(idx > 0 && sarray[idx - 1] == sarray[idx]) {
                count[idx] = count[idx - 1] + 1;
                if (count[idx] == k) {
                    idx = idx - k;
                }
            } else {
                count[idx] = 1;
            }
            idx++;
        }


        return new String(sarray, 0, idx);
    }
}
