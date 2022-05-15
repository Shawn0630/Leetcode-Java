package com.dynamic_programming;

import java.util.Stack;

public class MaximalRectangle {
    // https://leetcode.com/problems/maximal-rectangle/discuss/1572778/python-or-from-n4-to-n3-to-n2
    public int maximalRectangle(char[][] matrix) {
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
                    area = Math.max(area, (di - i + 1) * minW);
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
