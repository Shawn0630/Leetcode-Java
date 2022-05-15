package com.array.parentheses;

public class ValidParenthesisString {
    //              (    *   )
    // extraL       1        0
    // extraR       0    0   0
    // any               1

    // https://leetcode.com/problems/valid-parenthesis-string/discuss/107566/Java-12-lines-solution-backtracking
    // https://leetcode.com/problems/valid-parenthesis-string/discuss/139759/Java-Easy-solution.-No-recursion-dp-just-two-passes
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }

    private boolean checkValidString(String s, int start, int extraL) {
        if (extraL < 0) return false;
        for(int i = start; i < s.length(); i++) {
            char c= s.charAt(i);
            if (c == '(') {
                extraL++;
            } else if (c == ')') {
                if (extraL > 0) extraL--;
                else return false;
            } else if (c == '*') {
                return checkValidString(s, i + 1, extraL + 1) || checkValidString(s, i + 1, extraL) || checkValidString(s, i + 1, extraL - 1);
            }
        }

        return extraL == 0;
    }

    public boolean checkValidString2(String s) {
        int extraOpen = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                extraOpen++; // all * as (
            } else {
                if (extraOpen > 0) extraOpen--;
                else {
                    return false;
                }
            }
        }

        if (extraOpen == 0) return true;

        extraOpen = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                extraOpen++;
            } else {
                if (extraOpen > 0) extraOpen--;
                else {
                    return false;
                }
            }
        }
        if (extraOpen == 0) return true;

        return true;
    }
}
