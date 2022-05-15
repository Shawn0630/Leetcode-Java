package com.search;

public class FindaPeakElementII {
    // no two adjacent cells are equal
    // any peak
    // strictly greater than all of its adjacent
    // mat[i][j] > mat[i + 1][j]   mat[i][j] > mat[i][j + 1]   mat[i][j] > mat[i - 1][j]   mat[i][j] > mat[i][j - 1]
    // 1 <= m, n <= 500
    // a. mat[i][j] < mat[i + 1][j]
    // https://leetcode.com/problems/find-a-peak-element-ii/discuss/1543319/pyhton-3.-simple-recursive-solution-or-faster-than-90
    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat.length - 1;

        int midc;
        while (left < right) {
            int midr = left + (right - left) / 2;
            midc = findPeakGrid(mat[midr]);
            if (mat[midr][midc] < mat[midr + 1][midc]) {
                left = midr + 1;
            } else {
                right = midr;
            }
        }

        return new int[]{left, findPeakGrid(mat[left])};
    }

    // 1 2 3 2 1
    public int findPeakGrid(int[] row) {
        int left = 0, right = row.length - 1;

        while (left < right) { // exit condition left == right
            int mid = left + (right - left) / 2; // range of mid [0, row.length - 2]
            if (row[mid] < row[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
