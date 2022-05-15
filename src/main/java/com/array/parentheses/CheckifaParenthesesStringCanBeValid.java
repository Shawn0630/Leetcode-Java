package com.array.parentheses;

public class CheckifaParenthesesStringCanBeValid {

    //  "       )   )   (   )   )   )   "
    //          0   1   0   1   0   0
    // close    0   0   1   0   0   0
    // open     1   2   2   2   3   4
    // https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/1646716/Java-or-Short-and-Intuitive-Solution-or-O(n)
    // https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/1646716/Java-or-Short-and-Intuitive-Solution-or-O(n)
    public boolean canBeValid(String s, String locked) {
        int extraLeft = 0;
        int extraRight = 0;
        int possibleLeft = 0;
        int possibleRight = 0;

        // from left to right remove invalid right
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isLocked = locked.charAt(i) == '1';
            if (c == '(') {
                extraLeft++;
            } else if (c == ')') {
                if (extraLeft > 0) extraLeft--;
                else if (isLocked) extraRight++;
                else possibleLeft++;
            }
        }

        if (possibleLeft < extraRight) return false;


        extraLeft = 0;
        extraRight = 0;
        possibleRight = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            boolean isLocked = locked.charAt(i) == '1';

            if (c == ')') {
                extraRight++;
            } else if (c == '(') {
                if (extraRight > 0) extraRight--;
                else if (isLocked) extraLeft++;
                else possibleRight++;
            }
        }

        if (possibleRight < extraLeft) return false;

        return true;
    }

    public static void main(String args[]) {
        CheckifaParenthesesStringCanBeValid checkifaParenthesesStringCanBeValid = new CheckifaParenthesesStringCanBeValid();
        // "))()))"
        // "010100"
        checkifaParenthesesStringCanBeValid.canBeValid("))()))", "010100");
    }
}
