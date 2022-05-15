package com.dynamic_programming;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // i, j is the leftmost point, we'd like to find te rightmost point

                int area = 0;
                int minW = matrix[0].length - j;
                for(int di = i; di < matrix.length; di++) {
//                    int currW = minW;
                    for(int dj = j; dj < matrix[0].length; dj++) {
                        if (matrix[di][dj] != '1') {
//                            currW = dj - j;
                            minW = Math.min(minW, dj - j);
                            break;
                        }
                    }
//                    minW = Math.min(minW, currW);
                    if (di - i + 1 == minW) {
                        area = Math.max(area, (di - i + 1) * minW);
                    }
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }



    // 1    1   1
    // 1    1   1

    //  1   1   1
    //  1   2   2
    // https://leetcode.com/problems/maximal-square/discuss/600149/Python-Thinking-Process-Diagrams-DP-Approach
    public int maximalSquare2(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxLength = 0;
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
            maxLength = Math.max(maxLength, dp[i][0]);
        }
        for(int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
            maxLength = Math.max(maxLength, dp[0][i]);
        }


        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength * maxLength;
    }
}
