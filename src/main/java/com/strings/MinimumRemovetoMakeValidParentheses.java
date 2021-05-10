package com.strings;

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int open = 0;

        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                open++;
            } else if (chars[i] == ')') {
                if (open == 0) {
                    chars[i] = '*';
                } else {
                    open--;
                }
            }
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (open > 0 && chars[i] == '(') {
                chars[i] = '*';
                open--;
            }
        }

        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '*')
                chars[p++] = chars[i];
        }

        return new String(chars).substring(0, p);
    }
}
