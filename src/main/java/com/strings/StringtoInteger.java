package com.strings;

public class StringtoInteger {
    // s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'
    // constraint/assumptions
    // 1. could larger than integer, if so camp to max value/min value
    public int myAtoi(String s) {
        long number = 0;
        boolean seenSign = false;
        int sign = 1;
        boolean seenDigit = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (seenDigit || seenSign) {
                    return (int) (sign * number);
                }
            } else if (Character.isDigit(c)){
                seenDigit = true;
                number = number * 10 + c - '0';
                if (sign * number > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign * number < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else if (c == '+' || c == '-') {
                if (seenDigit || seenSign) {
                    return (int) (sign * number);
                }
                seenSign = true;
                if (c == '+') sign = 1;
                else sign = -1;
            } else { // other characters
                return (int)(sign * number);
            }
        }

        return (int) (sign * number);
    }
}
