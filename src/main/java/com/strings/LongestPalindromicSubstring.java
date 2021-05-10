package com.strings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int maxLen = Integer.MIN_VALUE;
        int pos = 0;
        String revS = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][revS.length()];

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < revS.length(); j++) {
                if (s.charAt(i) == revS.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }

                if (dp[i][j] > maxLen) {
                    // S = "abc435cba"，S' = "abc534cba"
                    if (revS.length() - 1 - j + dp[i][j] - 1 == i) {
                        maxLen = dp[i][j];
                        pos = i - dp[i][j] + 1;
                    }

                }
            }
        }

        return s.substring(pos, pos + maxLen);
    }


    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String possessed = preProcessor(s);
        int[] P = new int[possessed.length()];
        int C = 0; // center of the palindrome
        int R = 0; // right boundary of the palindrome
        for(int i = 1; i < possessed.length() - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]); // avoid P[i_mirror] exceed the right boundary
            } else {
                P[i] = 0;
            }

            while(possessed.charAt(i + 1 + P[i]) == possessed.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            if (P[i] + i > R) {
                C = i;
                R = P[i] + i;
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < possessed.length() - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);

    }

    private String preProcessor(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for(int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        sb.append('$');

        return sb.toString();
    }

}
