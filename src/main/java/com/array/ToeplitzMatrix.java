package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToeplitzMatrix {
    //[[1,2,3,4], ->
    // [5,1,2,3],
    // [9,5,1,2]]

    //[[11,74,0,93],
    // [40,11,74,7]]

    // [[36,59,71,15,26,82,87],
    //  [56,36,59,71,15,26,82],
    //  [15,0,36,59,71,15,26]]

    // https://leetcode.com/problems/toeplitz-matrix/discuss/271388/Java-Solution-for-Follow-Up-1-and-2
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;


        for(int i = 0; i < n; i++) {
            int x = i;
            int y = 0;
            while (isInside(x, y, n, m)) {
                if (y > 0) {
                    if (matrix[x][y] != matrix[x - 1][y - 1]) return false;
                }
                x++;
                y++;
            }
        }

        for(int i = 0; i < m; i++) {
            int x = 0;
            int y = i;
            while (isInside(x, y, n, m)) {
                if (x > 0) {
                    if (matrix[x][y] != matrix[x - 1][y - 1]) return false;
                }
                x++;
                y++;
            }
        }

        return true;
    }


    public boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // x => (m - 1 => 0), y = 0
        // x = 0 y => (0, n - 1)
        for(int i = 0; i < m + n - 1; i++) {
            int x = i <= m - 1 ? m - 1 - i : 0;
            int y = i <= m - 1 ? 0 : i - m + 1; // m + n - 2 - m + 1 = n - 1  m - 1 - m - 1

            int same = matrix[x][y];
            while (x >= 0 && x < m && y >= 0 && y < n) {
                if (same != matrix[x][y]) return false;
                x = x + 1;
                y = y + 1;
            }
        }

        return true;
    }

    //[[1,2,3,4], ->  1, 2, 3, 4
    // [5,1,2,3],
    // [9,5,1,2]]
    public boolean isToeplitzMatrix3(int[][] matrix) {
       int row = matrix.length;
       int col = matrix[0].length;

       List<Integer> buffer = new ArrayList<>();

       for(int i = 0; i < col; i++) {
           buffer.add(matrix[0][i]);
       }

       for(int i = 1; i < row; i++) {
           for(int j = 1; j < col; j++) {
               if (buffer.get(j - 1) != matrix[i][j]) return false;
           }
           buffer.remove(buffer.size() - 1);
           buffer.add(0, matrix[i][0]);
       }

       return true;
    }

    private boolean isInside(int x, int y, int n, int m) {
        return x < n && y < m;
    }

    public static void main(String[] args) {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        toeplitzMatrix.isToeplitzMatrix2(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}});
    }
}
