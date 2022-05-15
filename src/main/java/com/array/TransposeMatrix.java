package com.array;

public class TransposeMatrix {
    // [
    //  [   1,      2,      3],
    //  [   4,      5,      6],
    //  [   7,      8,      9]
    // ]
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] t = new int[n][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                t[j][i] = matrix[i][j];
            }
        }

        return t;

    }
}
