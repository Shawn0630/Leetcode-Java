package com.array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if(n <= 0) {
            return null;
        }

        int[][] ans = new int[n][n];

        int rStart = 0, rEnd = n - 1;
        int cStart = 0, cEnd = n - 1;

        int index = 1;
        while (cStart <= cEnd && rStart <= rEnd) {
            for (int c = cStart; c <= cEnd; c++) {
                ans[rStart][c] = index++;
            }
            for (int r = rStart + 1; r <= rEnd; r++) {
                ans[r][cEnd] = index++;
            }
            for (int c = cEnd - 1; c >= cStart; c--) {
                ans[rEnd][c] = index++;
            }
            for (int r = rEnd - 1; r >= rStart + 1; r--) {
                ans[r][cStart] = index++;
            }

            cStart++;
            cEnd--;
            rStart++;
            rEnd--;
        }

        return ans;
    }
}
