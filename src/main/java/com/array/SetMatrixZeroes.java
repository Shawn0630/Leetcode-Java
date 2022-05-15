package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    // https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    isCol = true;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    //      [   [0｜0,     1｜0,      2｜0,      0｜0],
    //          [3｜0,     0｜0,      5｜5,      0｜2],
    //          [1｜1,     3｜3,      1｜2,      0」5]
    //      ]

    //      [[0,        1,      2,      0],
    //       [3,        4,      5,      2],
    //       [1,        3,      1,      5]]


    //  [       [1,       2|0,      3,      4|0],
    //          [5|0,     0,        7|0,      8|0],
    //          [0,       10|0,       11|0,     12|0],
    //          [13|0,    14|0,       15|0,     0]
    //          ]


    //  [
    //      [-4|0,        -2147483648|0,    6|0,      -7,     0],
    //      [-8|0,            6|0,          -8|0,     -6|0,     0],
    //      [2147483647,    2,          -9,     -6,     -10]
    //
    //      ]
    // https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
    // top row and left column marking the zero index
    public void setZeroes2(int[][] matrix) {
        boolean col = false;
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) col = true;
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col) {
                matrix[i][0] = 0;
            }
        }

    }

    //  1   1   1   0
    //  1   0   0   1

    //

}
