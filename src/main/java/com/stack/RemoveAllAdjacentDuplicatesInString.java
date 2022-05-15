package com.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    //          a    b   b   a   c   a
    //  a  => ab => a{bb} => {aa} => c => a
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!stack.empty()) {
            str.insert(0, stack.pop());
        }

        return str.toString();
    }

    public String removeDuplicates2(String s) {
        int idx = 0;

        char[] sarray = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            sarray[idx] = sarray[i];
            if (idx > 0 && sarray[idx] == sarray[idx - 1]) {
                idx = idx - 2;
            }
            idx++;
        }

        return new String(sarray, 0, idx);
    }
}
