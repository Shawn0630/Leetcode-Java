package com.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;

        char[] cs = s.toCharArray();
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            map.put(cs[right], map.getOrDefault(cs[right], 0) + 1);
            while (map.get(cs[right]) > 1 && left < right) {
                map.put(cs[left], map.get(cs[left]) > 1 ? map.get(cs[left]) - 1 : 0);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}
