package com.array.parentheses;

public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int needLeft = 0;
        int needRight = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                needRight++;
            } else if (c == ')') {
                if (needRight > 0) needRight--;
                else needLeft++;
            }
        }

        return needLeft + needRight;
    }
}
