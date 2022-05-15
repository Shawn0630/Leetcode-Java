package com.dynamic_programming;

public class ChampagneTower {
    //                1                                 1
    //            1       1                             2
    //      1         1         1                       3
    //  1       1           1       1                   4

    //                    (0,0)
    //              (1,0)       (1,1)
    //    (2,0)           (2,1)       (2,2)
    // (3,0)        (3,1)       (3,2)       (3,3)
    // get from (i - 1, j - 1) and and (i - 1, j)

    // top-down incremental add
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[0][0] = (double) poured;
        for(int i = 0; i <= query_row; i++) {
            for(int j = 0; j <= i; j++) {
                double q = (dp[i][j] - 1.0) / 2;
                if (q > 0) {
                    dp[i + 1][j] += q;
                    dp[i + 1][j + 1] += q;
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
