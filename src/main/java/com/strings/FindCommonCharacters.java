package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    // https://leetcode.com/problems/find-common-characters/discuss/249739/Java-10ms-38mb-clear-solution-with-comments
    public List<String> commonChars(String[] words) {
        int[] dict = new int[26];
        Arrays.fill(dict, Integer.MAX_VALUE);

        for(String word : words) {
            int[] cur = new int[26];
            Arrays.fill(cur, 0);
            for(char c : word.toCharArray()) {
                cur[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                dict[i] = Math.min(dict[i], cur[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < dict[i]; j++) {
                ans.add(Character.toString((char) ('a' + i)));
            }
        }

        return ans;
    }
}
