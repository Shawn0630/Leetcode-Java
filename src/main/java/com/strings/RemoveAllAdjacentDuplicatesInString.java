package com.strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    // abba => ""
    // abbaca => ca
    // abbbaaca => ca
    // azxxzy => ay
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if(!stack.empty() && stack.peek().equals(s.charAt(i))) {
                //while (i < s.length() && stack.peek().equals(s.charAt(i))) i++; // pitfall: move twice !!!!
                i++;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
                i++;
            }
        }

        char[] c = new char[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.empty()) {
            c[idx--] = stack.pop();
        }

        return new String(c);
    }
}
