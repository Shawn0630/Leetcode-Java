package com.array.two_pointers;

import java.util.Arrays;

public class KdiffPairsinanArray {
    // unique
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int counter = 0;

        while (left < nums.length) {
            if (left == 0 || nums[left] != nums[left - 1]) { // k == 0
                int right = left + 1;
                while (right < nums.length && nums[right] - nums[left] <= k) {
                    if (nums[right] - nums[left] == k) {
                        counter++;
                        break;
                    }
                    right++;
                }
            }
            left++;
        }

        return counter;
    }
}
