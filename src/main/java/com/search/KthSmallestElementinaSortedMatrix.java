package com.search;

public class KthSmallestElementinaSortedMatrix {
    /*
    * [1, 5, 9],
    * [10,11,13],
    * [12,13,15]
    *
    * */
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1547354/3-Different-Approaches-for-Interview-With-Comments
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];

        while (lo < high) {
            int mid = lo + (high - lo) / 2;
            int count = 0;
            for(int i = 0, j = matrix[0].length - 1; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                if (j >= 0) {
                    count += (j + 1);
                }
            }
            if (count >= k) high = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}
