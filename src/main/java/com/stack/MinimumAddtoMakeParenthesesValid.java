package com.stack;

public class MinimumAddtoMakeParenthesesValid {
    // (  )  )
    // 1  0  -1
    //               1  1  1  1
    //           ( ) )  )  (  (
    //           1 0 -1 -2 -1 0
    //openOnly   1 0 0  0  1  2
    //closeOnly  0 0 1  2  0  0
    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181132/C%2B%2BJavaPython-Straight-Forward-One-Pass
    public int minAddToMakeValid(String s) {
        int closeOnly = 0;
        int openOnly = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openOnly++;
            } else if (s.charAt(i) == ')') {
                if (openOnly > 0) {
                    openOnly--;
                } else {
                    closeOnly++;
                }
            }
        }

        return openOnly + closeOnly;
    }
}
