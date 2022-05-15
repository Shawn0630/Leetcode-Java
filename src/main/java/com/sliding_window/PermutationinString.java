package com.sliding_window;

import java.util.Arrays;

public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int[] pattern = new int[26];
        Arrays.fill(pattern, 0);

        int counter = 0;
        for(char c : s1.toCharArray()) {
            if (pattern[c - 'a'] == 0) counter++;
            pattern[c - 'a']++;
        }

        int left = 0, right = 0;

        while (right < s2.length()) {
            char rightC = s2.charAt(right);
            pattern[rightC - 'a']--;
            if (pattern[rightC - 'a'] == 0) counter--;

            while (left <= right && counter == 0) {
                if (isMatch(pattern)) return true;
                char leftC = s2.charAt(left);
                if (pattern[leftC - 'a'] == 0) counter++;
                pattern[leftC - 'a']++;
                left++;
            }



            right++;
        }

        return false;
    }

    private boolean isMatch(int[] pattern) {
        for(int p : pattern) {
            if (p != 0) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        PermutationinString permutationinString = new PermutationinString();
        permutationinString.checkInclusion("a", "ab");
    }
}
