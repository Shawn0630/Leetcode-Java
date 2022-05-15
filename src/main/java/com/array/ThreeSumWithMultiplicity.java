package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {
    //  0       1       2       3       4       5       6       7       8       9
    // [1,      1,      2,      2,      3,      3,      4,      4,      5,      5]

    //
    // https://leetcode.com/problems/3sum-with-multiplicity/discuss/767824/Two-pointer-solution-C%2B%2B

    //  1   1   1   2   3   3
    //  i   j   k
    //  3
    public int threeSumMulti(int[] arr, int target) {
        double mod = 1e9 + 7;

        Arrays.sort(arr);

        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                int countJ=1, countK=1;
                if (arr[i] + arr[j] + arr[k] == target) {
                    while (j < k && arr[j] == arr[j + 1]) {
                        countJ++;
                        j++;
                    } // exit j == k || ...
                    while (j < k && arr[k] == arr[k - 1]) {
                        countK++;
                        k--;
                    } // exit j == k || ...
                    // A[lo]==A[hi]
                    if (j == k) ans = (int) ((ans + countJ * (countJ - 1) / 2) % mod);
                        // A[lo]!=A[hi]
                    else ans = (int) ((ans + countJ * countK) % mod);
                    j++; k--;
                } else if (arr[i] + arr[j] + arr[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }


        return ans;
    }
}
