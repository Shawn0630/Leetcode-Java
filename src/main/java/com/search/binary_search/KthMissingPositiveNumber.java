package com.search.binary_search;

public class KthMissingPositiveNumber {
    //  0    1   2    3    4
    //  2,   3,  4,   7,   11  k = 5

    // 1           5 6   8 9
    //  9

    //  7 + 5 - (7 - 3 - 1) = 7 + 5 - 3 = 9
    // left = 1, right = 11
    // mid = 6
    // arr is strictly increasing, no duplications
    // k could larger than the last element in the arr
    // https://leetcode.com/problems/kth-missing-positive-number/discuss/1004535/Python-Two-solutions-O(n)-and-O(log-n)-explained
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int diff = arr[mid] - mid - 1;
            if (diff < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // exit condition : left == right
        return right + k;
    }

    //  0       1       2       3       4
    //  1       2       3       4       5
    // [2,      3,      4 ,     7,      11], k = 5
    //  l                                r
    //                  m
    public int findKthPositive2(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int diff = arr[mid] - mid - 1;
            if (diff < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right + k;
    }

}
