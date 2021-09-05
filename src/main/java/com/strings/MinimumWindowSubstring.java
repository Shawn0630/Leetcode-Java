package com.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> pattern = new HashMap<>();
        for (Character tc : t.toCharArray()) {
            pattern.put(tc, pattern.getOrDefault(tc, 0) + 1);
        }

        int left = 0, right = 0;
        int bestLeft = 0, bestRight = 0, minLength = -1;

        // Number of unique characters in t, which need to be present in the desired window.
        int required = pattern.size();

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (pattern.containsKey(c) && windowCounts.get(c).intValue() == pattern.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (minLength == -1 || right - left + 1 < minLength) {
                    bestLeft = left;
                    bestRight = right;
                    minLength = right - left + 1;
                }

                c = s.charAt(left);
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (pattern.containsKey(c) && windowCounts.get(c) < pattern.get(c)) {
                    formed--;
                }


                left++;
            }

            right++;
        }


        return minLength == -1 ? "" : s.substring(bestLeft, bestRight + 1);
    }
}
