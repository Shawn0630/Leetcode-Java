package com.dynamic_programming;

public class LongestMountaininArray {
    //          0   1   2   3   4   5   6
    //          [2,  1,  4,  7,  3,  2,  5]
    // inc       1   1   2   3   1   1
    // end       1   0   0   0   4
    // sofar     0   0   0   0   4
    //  1   1   2   3
    //  0   0   0   0   4   5   0
    // 5

    // subarray question
    // longestMountainEndingAt
    // longestMountainSoFar
    public int longestMountain(int[] arr) {
        int[] longestMountainEndingAt = new int[arr.length];
        int[] increasingArrayEndingAt = new int[arr.length];

        increasingArrayEndingAt[0] = 1;
        longestMountainEndingAt[0] = 0;
        int longestMountainSoFar = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]) {
                increasingArrayEndingAt[i] = increasingArrayEndingAt[i - 1] + 1;
                longestMountainEndingAt[i] = 0;
            } else if (arr[i] == arr[i - 1]) {
                increasingArrayEndingAt[i] = 1;
                longestMountainEndingAt[i] = 0;
            } else { // arr[i] > arr[i - 1]
                increasingArrayEndingAt[i] = 1;
                longestMountainEndingAt[i] = longestMountainEndingAt[i - 1] > 0 ? longestMountainEndingAt[i - 1] + 1 : increasingArrayEndingAt[i  - 1] == 1 ? 0 : increasingArrayEndingAt[i - 1] + 1;
            }

            longestMountainSoFar = Math.max(longestMountainSoFar, longestMountainEndingAt[i]);
        }

        return longestMountainSoFar;
    }
}
