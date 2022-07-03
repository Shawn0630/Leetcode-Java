package com.sorting;

import java.util.Arrays;

public class RussianDollEnvelopes {

    // [[5,4],[6,4],[6,7],[2,3]]
    // [[2,3] [5,4],[6,4],[6,7]]
    //    1     2     2     3
    // https://leetcode.com/problems/russian-doll-envelopes/discuss/2071477/Best-Explanation-with-Pictures
    public int maxEnvelopes(int[][] envelopes) {
        int[][] dp = new int[envelopes.length][2];

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1]; // each a[0] should have at most one
            } else {
                return a[0] - b[0];
            }
        });

        dp[0] = envelopes[0];
        int maxLen = 1;

        for(int i = 1; i < envelopes.length; i++) {
            int pos = binarySearch(dp, maxLen, envelopes[i][1]);

            if (pos == maxLen) {
                dp[pos] = envelopes[i];
                maxLen++;
            } else if (dp[pos][1] > envelopes[i][1]) {
                dp[pos] = envelopes[i];
            }
        }

        return maxLen;
    }
    // 1    2   3   4
    // l            r
    //      m   l   r
    //          m   lr

    private int binarySearch(int[][] dp, int maxLen, int target) {
        int left = 0;
        int right = maxLen;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == dp[mid][1]) {
                right = mid;
            } else if (target > dp[mid][1]) {
                left = mid + 1;
            } else { // target < mid
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        russianDollEnvelopes.maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}});
        //russianDollEnvelopes.maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}});
    }
}
