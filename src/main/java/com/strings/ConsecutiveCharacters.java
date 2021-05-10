package com.strings;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 1;
        int len = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                prev = s.charAt(i);
                max = Math.max(len, max);
                len = 1;
            } else {
                len++;
            }
        }

        return max;
    }
}
