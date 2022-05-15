package com.array.two_pointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // s consists of English letters, digits, symbols and spaces.
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;

        while (right < s.length()) {
            char cright = s.charAt(right);
            if (!set.contains(cright)) {
                set.add(cright);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (left <= right) {
                    char cleft = s.charAt(left);
                    set.remove(cleft);
                    left++;
                    if (cleft == cright) break;
                }
                set.add(cright);
            }

            right++;
        }

        return maxLength;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
    }
}
