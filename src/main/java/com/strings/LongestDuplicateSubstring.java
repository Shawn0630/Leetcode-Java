package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstring {
    // https://leetcode.com/problems/longest-duplicate-substring/discuss/1287103/Java-or-DP-or-Rolling-Hash-and-Binary-Search
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int len = 0;
        int end = 0;
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++)
                if (i < j && s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > len) {
                        end = j;
                        len = dp[i][j];
                    }
                }
        return len == 0 ? "" : s.substring(end - len, end);
    }

    // https://leetcode.com/problems/longest-duplicate-substring/discuss/1548032/Simple-C%2B%2B-Solution-using-Sliding-Window-and-Map
    public String longestDupSubstringSlidingWindow(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int end = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        for(int i = 0; i < s.length(); i++) {
            List<Integer> nextStarts = map.get(s.charAt(i));
            nextStarts.remove(0);
            for(int nextStart : nextStarts) {
                int start = i;
                int len = 0;
                while (start < s.length() && nextStart < s.length() && s.charAt(start) == s.charAt(nextStart)) {
                    start++;
                    nextStart++;
                    len++;
                }
                if (max < len) {
                    max = len;
                    end = nextStart;
                }


                // this is required when we achieved the longest substring possible
                if(max == s.length()- i - 1) return s.substring(end - max, end);
            }
        }

        return max == Integer.MIN_VALUE ? "" : s.substring(end - max, end);
    }

    // https://leetcode.com/problems/longest-duplicate-substring/discuss/695003/Super-simple-or-Using-suffix-array-or-Java-or-Python
    public String longestDupSubstringSuffixArray(String s) {
        return null;
    }
}
