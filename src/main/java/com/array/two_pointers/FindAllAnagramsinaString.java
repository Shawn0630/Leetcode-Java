package com.array.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {
    // 0    1   2   3   4   5   6   7   8   9           [0,6]
    // c    b   a   e   b   a   b   a   c   d
    //
    // why two pointer works?
    // remember pattern length is fixed.
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] pattern = new int[26];
        int[] string = new int[26];

        for(char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }

        for(int i = 0; i < p.length(); i++) {
            string[s.charAt(i) - 'a']++;
        }

        if (isAnagrams(pattern, string)) {
            ans.add(0);
        }

        for(int i = 1; i <= s.length() - p.length(); i++) {
            string[s.charAt(i - 1) - 'a']--;
            string[s.charAt(i + p.length() - 1) - 'a']++;
            if (isAnagrams(pattern, string)) ans.add(i);
        }


        return ans;
    }

    private boolean isAnagrams(int[] pattern, int[] string) {
        for(int i = 0; i < 26; i++) {
            if (pattern[i] != string[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        FindAllAnagramsinaString findAllAnagramsinaString = new FindAllAnagramsinaString();
        findAllAnagramsinaString.findAnagrams("cbaebabacd", "abc");

    }
}
