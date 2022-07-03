package com.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {
    Integer[][] dp;
    Boolean[][] isPali;
    public int countSubstrings(String s) {
        dp = new Integer[s.length()][s.length()];
        isPali = new Boolean[s.length()][s.length()];

        return countSubstrings(s, 0, dp.length - 1);
    }


    // a    a   a
    // 1    1   1
    //      3   6
    private int countSubstrings(String s, int start, int end) {
        if (start > end) {
            return 0;
        } else if (dp[start][end] != null) {
            return dp[start][end];
        } else if (start == end) {
            dp[start][end] = 1;
        } else if (start + 1 == end) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = 3;
            } else {
                dp[start][end] = 2;
            }
        } else {
            int sum = countSubstrings(s, start, end - 1) + countSubstrings(s, start + 1, end) - countSubstrings(s, start + 1, end - 1);
            if (isPali(s, start, end)) {
                sum += 1;
            }
            dp[start][end] = sum;
        }

        return dp[start][end];
    }

    private boolean isPali(String s, int start, int end) {
        if (start > end) {
            return false;
        } else if (isPali[start][end] != null) {
            return isPali[start][end];
        } else if (start == end) {
            isPali[start][end] = true;
        } else if (start + 1 == end) {
            return s.charAt(start) == s.charAt(end);
        } else {
            isPali[start][end] = s.charAt(start) == s.charAt(end) && isPali(s, start + 1, end - 1);
        }

        return isPali[start][end];
    }
}
