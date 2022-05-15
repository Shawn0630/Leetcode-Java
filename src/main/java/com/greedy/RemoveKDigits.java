package com.greedy;

import java.util.Stack;

public class RemoveKDigits {

    //  1   4   3   2   2       1   9  k = 3
    //  1           2           1   9


    //  1   0   2   0   0       k = 1
    //      0   2   0   0

    // 1    3   2   1   4 => 1  2   1   4 The left digit has more impact
    //
    // https://leetcode.com/problems/remove-k-digits/discuss/88678/Two-algorithms-with-detailed-explaination
    // https://1e9.medium.com/monotonic-queue-notes-980a019d5793
    public String removeKdigits(String num, int k) { // start from removing one
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.empty() && stack.peek() > num.charAt(i)) { // num.charAt(i) <= stack.peek
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        if (sb.length() == 0) {
            return "0";
        }

        String returnedValue = sb.reverse().toString();

        i = 0;
        while (i < returnedValue.length() - 1 && returnedValue.charAt(i) == '0') i++;
        return returnedValue.substring(i);
    }
}
