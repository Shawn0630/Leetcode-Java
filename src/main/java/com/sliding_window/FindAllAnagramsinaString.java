package com.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pattern = new int[26];
        Arrays.fill(pattern, 0);
        int counter = 0;

        List<Integer> ans = new ArrayList<>();

        for(char c : p.toCharArray()) {
            if (pattern[c - 'a'] == 0) counter++;
            pattern[c - 'a']++;
        }

        int left = 0, right = 0;
        int[] window = new int[26];
        Arrays.fill(window, 0);

        while (right < s.length()) {
            char rchar = s.charAt(right);
            window[rchar - 'a']++;
            if (pattern[rchar - 'a'] > 0 && window[rchar - 'a'] == pattern[rchar - 'a'])counter--;

            // bacd  ca
            while (left <= right && counter == 0) {
                if (isSamePattern(pattern, window)) ans.add(left);
                char lchar = s.charAt(left);
                window[lchar - 'a']--;
                if (pattern[lchar - 'a'] > 0 && window[lchar - 'a'] < pattern[lchar - 'a'])counter++;
                left++;
            }

            right++;
        }

        return ans;

    }

    private boolean isSamePattern(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
}
