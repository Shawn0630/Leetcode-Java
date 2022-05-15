package com.counting;

public class CountSortedVowelStrings {
    // (a, e, i, o, u)

    // aaa
    // ..  5
    // aau
    // aee
    // ..   4
    // aeu
    // aix  3
    // aox  2
    // aux  1

    // eex  4
    // eix  3
    // eox  2
    // eux  1


    //  a                       e               i               o               u
    //  ax                      ex              ix              ox              ux
    //  aax,aex,aix,aox,aux    eex ...eux     iix,...,iux    oox,...oux         uux

    // https://leetcode.com/problems/count-sorted-vowel-strings/discuss/1193637/3-different-solutions-(backtracking-dynamic-programming-math)
    Integer[][] dp;
    public int countVowelStrings(int n) {
        dp = new Integer[n + 1][6];
        return countVowelStringsDFS(n, 1);
    }

    private int countVowelStringsDFS(int n, int cur) {
        if (n == 0) {
            return 1;
        }

        if (dp[n][cur] != null) {
            return dp[n][cur];
        }

        int sum = 0;
        for(int i = cur; i <= 5; i++) {
            sum += countVowelStringsDFS(n - 1, i);
        }

        dp[n][cur] = sum;
        return dp[n][cur];
    }
}
