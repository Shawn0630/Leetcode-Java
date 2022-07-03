package com.dynamic_programming;

public class OnesandZeroes {
    Integer[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[m + 1][n + 1][strs.length];
        int[][] counts = new int[strs.length][2];
        int idx = 0;
        for(String str : strs) {
            for(char c : str.toCharArray()) {
                if (c == '0') {
                    counts[idx][0]++;
                } else {
                    counts[idx][1]++;
                }
            }
            idx++;
        }


        return findMaxForm(counts, m, n, 0);
    }

    // ["10","0001","111001","1","0"]
    // 4 "0" 3 "1"

    // keep: (3  2)
    //      keep    (0, 1)
    //      skip    (3, 2)
    // skip: (4, 3)
    private int findMaxForm(int[][] counts, int m, int n, int idx) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (idx >= counts.length) {
            return 0;
        }

        if (dp[m][n][idx] != null) {
            return dp[m][n][idx];
        }
        int keep = Integer.MIN_VALUE;
        if (m >= counts[idx][0] && n >= counts[idx][1]) {
            keep = 1 + findMaxForm(counts, m - counts[idx][0], n - counts[idx][1], idx + 1);
        }
        int skip = findMaxForm(counts, m, n, idx + 1);

        dp[m][n][idx] = Math.max(keep, skip);
        return dp[m][n][idx];
    }
}
