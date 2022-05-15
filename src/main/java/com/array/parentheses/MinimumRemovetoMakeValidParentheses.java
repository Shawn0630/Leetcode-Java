package com.array.parentheses;

public class MinimumRemovetoMakeValidParentheses {
    // lee(t(c)o)de)
    public String minRemoveToMakeValid(String s) {

        StringBuilder removeInvalidRight = minRemove(s, '(', ')');
        StringBuilder removeInvalidLeft = minRemove(removeInvalidRight.reverse().toString(), ')', '(');

        return removeInvalidLeft.reverse().toString();
    }

    private StringBuilder minRemove(String s, char open, char close) {
        int openCount = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if (c == open) {
                openCount++;
            } else if (c == close) {
                if (openCount == 0) continue;
                openCount--;
            }
            sb.append(c);
        }

        return sb;
    }

    public String minRemoveToMakeValid2(String s) {
        String validClose = removeInvalid(s, '(', ')');
        String validOpen = removeInvalid(new StringBuilder(validClose).reverse().toString(), ')', '(');

        return new StringBuilder(validOpen).reverse().toString();
    }

    private String removeInvalid(String s, char open, char close) {
        StringBuilder sb = new StringBuilder();

        int openCounter = 0;
        for(char c : s.toCharArray()) {
            if (c == open) {
                openCounter++;
                sb.append(c);
            } else if (c == close) {
                if (openCounter > 0) {
                    openCounter--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
