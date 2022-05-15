package com.strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    // stack
    // "deeedbbcccbdaa" 3

    // stack
    // d, 1 => e, 1 => e, 2 => e, 3
    // d, 1
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            if (!stack.empty() && stack.peek().c == s.charAt(i)) {
                int occurance = stack.peek().occurance + 1;
                stack.push(new Node(s.charAt(i), occurance));
                if (occurance == k) {
                    while (occurance > 0) {
                        stack.pop();
                        occurance--;
                    }
                }
                i++;
            } else {
                stack.push(new Node(s.charAt(i), 1));
                i++;
            }
        }

        char[] c = new char[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.empty()) {
            c[idx--] = stack.pop().c;
        }

        return new String(c);
    }

    private class Node {
        Character c;
        int occurance;

        public Node(Character c, int occurance) {
            this.c = c;
            this.occurance = occurance;
        }
    }
}
