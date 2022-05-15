package com.strings;

public class ValidNumber {
    // https://leetcode.com/problems/valid-number/discuss/23910/Simple-one-line-regex-solution
    // https://leetcode.com/problems/valid-number/discuss/24057/Accepted-java-solution-with-recursion

    // A decimal number or an integer.
    //(Optional) An 'e' or 'E', followed by an integer.

    // s consists of only English letters (both uppercase and lowercase),
    // digits (0-9),
    // plus '+', minus '-', or
    // dot '.'.

    // enumerate invalid cases

    // A5
    // E5
    // 0E
    // 0A
    // .E
    // .9E+4
    // +E

    // https://leetcode.com/problems/valid-number/discuss/161602/3-solutions-1-java-dfa-solution-with-graph-2-if-else-with-flags-3-regex
    public boolean isNumber(String s) {
        boolean seenDigitBeforeE = false;
        boolean seenE = false;
        boolean seenDigitAfterE = false;
        boolean seenDot = false;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (Character.isDigit(c)) {
                if (seenE) {
                    seenDigitAfterE = true;
                } else {
                    seenDigitBeforeE = true;
                }
            } else if (c == 'E' || c == 'e') {
                if (seenE) return false; // 3ee3 invalid
                seenE = true;
            } else if (c == '.') {
                if (seenE) {
                    return false; // e9.5
                } else {
                    if (seenDot) return false; // ..5
                    seenDot = true;
                }
            } else {
                return false;
            }
        }

        return seenE ? seenDigitBeforeE && seenDigitAfterE : seenDigitBeforeE;
    }


    // s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.

    // A decimal number or an integer.
    //(Optional) An 'e' or 'E', followed by an integer.
    public boolean isNumber2(String s) {
        boolean seenE = false;
        boolean seenDot = false;
        boolean seenDigitBeforeE = false;
        boolean seenDigitAfterE = false;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) {
                    seenDigitAfterE = true;
                } else {
                    seenDigitBeforeE = true;
                }
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (c == '.') {
                if (seenDot || seenE) { // .5 or .5.
                    return false;
                }

                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (!seenDigitBeforeE || seenE) { // e5 or ee
                    return false;
                }
                seenE = true;
            } else {
                return false;
            }
        }

        return seenE ? seenDigitBeforeE && seenDigitAfterE : seenDigitBeforeE;
    }
}
