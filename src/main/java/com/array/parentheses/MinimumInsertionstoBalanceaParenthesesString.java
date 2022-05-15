package com.array.parentheses;

public class MinimumInsertionstoBalanceaParenthesesString {
    //              )    )      (       )       )       (
    //  needleft    1    1      1       1       1       2
    //  needRight   1    0      2       1       0       0

    //              (    (   )   )   )   (   (   )   )   )   (   )   (   )   )   )   )
    //  needL                                                                    1
    //  needR       2          3   2   0   2   4   3   2   0   2   0   2   1   0   1   0
    //  missingR                     1                   2       3       3   3
    public int minInsertions(String s) {
        int needLeft = 0;
        int needRight = 0;
        int missingRight = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                missingRight += needRight;
                needRight = 2;
            } else if (c == ')') {
                if (needRight == 0) {
                    needLeft += 1;
                    needRight += 1;
                } else {
                    needRight--;
                }
            }
        }

        return needLeft + needRight + missingRight;
    }
}
