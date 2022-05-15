package com.array.parentheses;

public class ScoreofParentheses {
    public int scoreOfParentheses(String s) {
        return scoreOfParentheses(s, 0);
    }

    //() => 1
    //()() => 2
    // (()) => 2
    // ((())) => 2 * (()) =>
    // https://leetcode.com/problems/score-of-parentheses/discuss/141779/Java-8ms-11-lines-recursion-with-explanation
    private int scoreOfParentheses(String s, int start) {
        if (start >= s.length()) {
            return 0;
        }

        int cur = 0;
        int i = start;
        while (i < s.length()){
            char c = s.charAt(i);
            if (c == '(') {
                char nc = s.charAt(++i);
                if (nc == '(') {
                    cur += (2 * scoreOfParentheses(s, i));
                } else if (nc == ')') {
                    cur += (1 + scoreOfParentheses(s, i + 1));
                }
            } else {
                return cur;
            }
        }

        return cur;
    }

    int i = 0;
    public int scoreOfParentheses2(String s) {
        int score = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c == '(') {
                boolean isDouble = false;
                if (s.charAt(i) == '(') {
                    isDouble = true;
                }
                int subScore = scoreOfParentheses2(s);
                if (isDouble) {
                    score += (2 * subScore);
                } else {
                    score += 1;
                }
            } else if (c == ')') {
                break;
            }
        }

        return score;
    }
}
