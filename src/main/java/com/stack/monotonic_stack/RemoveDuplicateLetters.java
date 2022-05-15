package com.stack.monotonic_stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {
    // 0    1   2   3   4
    // b    c   a   b   c
    // 2    2   -1  -1  -1

    // 0    1   2   3   4   5   6   7
    // c    b   a   c   d   c   b   c
    // 2    2   -1  6   5   6  -1  -1
    //
    public String removeDuplicateLetters(String s) {
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        int[] counter = new int[26];
        Arrays.fill(counter, 0);

        for(char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        for(char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                while (!stack.empty() && stack.peek() > c && counter[stack.peek() - 'a'] > 0) {
                    seen.remove(stack.pop());
                }
                stack.push(c);
                seen.add(c);
            }
            counter[c - 'a']--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
