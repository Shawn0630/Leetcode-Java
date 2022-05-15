package com.dynamic_programming;

public class DominoandTrominoTiling {
    //https://leetcode.com/problems/domino-and-tromino-tiling/discuss/215670/Java-O(N)-Math-Proof-on-Paper
    public int numTilings(int N) {
        if (N <= 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int mod = (int) 1e9 + 7;
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i- 3]) % mod;
        }
        return (int) dp[N];
    }
}
