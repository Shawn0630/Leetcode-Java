package com.sorting;

import java.util.Arrays;

public class MaxNumberofKSumPairs {

    //  3,  1,  3,  4,  3
    //  1   3   3   3   4   k = 6
    //
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        int counter = 0;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];

            if (leftVal + rightVal == k) {
                counter++;
                left++;
                right--;
            } else if (leftVal + rightVal > k) {
                right--;
            } else {
                left++;
            }
        }

        return counter;
    }
}
