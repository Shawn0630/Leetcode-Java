package com.array.two_pointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // 0    1   2   3   4   5   6   7   8   9   10  11  12
    // A    D   O   B   E   C   O   D   E   B   A   N   C
    // left                    right
    //ABC
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> pattern = new HashMap<>();
        int count = 0;

        for (char c : t.toCharArray()) {
            if (!pattern.containsKey(c)) {
                count++;
            }
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }

        int right = 0, left = 0;
        int minStart = -1, minEnd = -1;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (pattern.containsKey(c)) {
                pattern.put(c, pattern.get(c) - 1);
                if (pattern.get(c) == 0) {
                    count--;
                }
            }

            while (left < right && count == 0) {
                // left == right || pattern.containsKey
                char cleft = s.charAt(left);
                if (right - left + 1 < minLength) {
                    minStart = left;
                    minEnd = right;
                    minLength = right - left + 1;
                }

                if (pattern.containsKey(cleft)) {
                    pattern.put(cleft, pattern.get(cleft) + 1);
                    if (pattern.get(cleft) > 0) {
                        count++;
                    }
                }
                left++;
            }

            right++;
        }

        return minStart == -1 || minEnd == -1 ? "" : s.substring(minStart, minEnd + 1);
    }
}
