package com.array.matrix;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0;
        int j = 0;

        int idx = 1;
        int curDir = 0;
        while (idx < n * n) {
            System.out.println(i + " " + j + " = " + idx);
            matrix[i][j] = idx;

            int nextI = i + dirs[curDir][0];
            int nextJ = j + dirs[curDir][1];

            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || matrix[nextI][nextJ] != 0) {
                curDir = (curDir + 1) % dirs.length;// 0 -> 1 -> 2 -> 3 ... dirs.length - 1 -> 0
                nextI = i + dirs[curDir][0];
                nextJ = j + dirs[curDir][1];
            }

            i = nextI;
            j = nextJ;
            idx++;
        }

        return matrix;
    }


    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        spiralMatrixII.generateMatrix(3);
    }
}
