package com.strings;

public class LongestRepeatingCharacterReplacement {
    // https://leetcode.com/problems/longest-repeating-character-replacement/discuss/1400228/Java-Counter-%2B-Sliding-Window-Solution
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int[] frequency = new int[26];
        int maxFrequency = -1;
        int maxLength = -1;

        while (right < s.length()) {
            char c = s.charAt(right);
            frequency[c - 'A']++;
            maxFrequency = maxFrequency == -1 || maxFrequency < frequency[c - 'A'] ? frequency[c - 'A'] : maxFrequency;

            while (left <= right && maxFrequency + k < right - left + 1) {
                c = s.charAt(left);
                frequency[c - 'A']--;
                maxFrequency = maxFrequency == -1 || maxFrequency < frequency[c - 'A'] ? frequency[c - 'A'] : maxFrequency;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}
