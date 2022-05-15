package com.search;

public class PalindromePartitioningII {
    Integer dp[][];
    public int minCut(String s) {
        dp = new Integer[s.length()][s.length()];
        return minCut(s, 0, s.length() - 1);
    }

    private int minCut(String s, int start, int end) {
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        if (start == end) {
            dp[start][end] = 0;
            return dp[start][end];
        } else if (isPalindrome(s.substring(start, end + 1))) {
            dp[start][end] = 0;
            return dp[start][end];
        }

        for(int i = start; i < end; i++) {
//            min = Math.min(min, minCut(s, start, i) + minCut(s, i + 1, end));
            if (isPalindrome(s.substring(start, i + 1))) {
                min = Math.min(min, minCut(s, i + 1, end));
            }
        }

        dp[start][end] = min + 1;
        return dp[start][end];
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true; // by definition
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
