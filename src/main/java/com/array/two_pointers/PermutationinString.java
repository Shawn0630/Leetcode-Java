package com.array.two_pointers;

import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
    // constraint
    // s1, s2 lower case letter
    // s1 s2 not null
    //       e    i   b   a   o   o   o
    //      left/right
    //                left right
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false; // abc a => false
        }

        Map<Character, Integer> pattern = new HashMap();
        int count = 0;

        for(char c : s1.toCharArray()) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }

        count = pattern.keySet().size();

        int right = 0, left = 0;

        while (right < s2.length()) {
            char cright = s2.charAt(right);
            if (pattern.containsKey(cright)) {
                pattern.put(cright, pattern.get(cright) - 1);
                if (pattern.get(cright) == 0) {
                    count--;
                }
                while (left <= right && count == 0) { //"a", "ab" wrong ans if no left <= right
                    char cleft = s2.charAt(left);
                    if (pattern.containsKey(cleft)) {
                        pattern.put(cleft, pattern.get(cleft) + 1);
                        if (pattern.get(cleft) > 0) {
                            count++;
                        }
                    }

                    if (right - left + 1 == s1.length()) {
                        return true;
                    }

                    left++;
                }
            }

            right++;
        }

        return false;
    }
}
