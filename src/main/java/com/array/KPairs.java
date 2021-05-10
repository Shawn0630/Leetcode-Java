package com.array;

import java.util.Arrays;

public class KPairs {
    public int findPairs(int[] nums, int k) {
        if (nums == null && k < 0) {
            return 0;
        }
        Arrays.sort(nums);

        int i = 0;
        int j = 0;
        int pair = 0;

        while (i < nums.length && j < nums.length) {
            if (i != j && nums[i] + k == nums[j]) {
                pair++;
                while (j < nums.length && (nums[i] + k == nums[j])) j++;
            } else if (nums[i] + k > nums[j]) {
                j++;
            } else {
                i++;
            }
        }

        return pair;
    }
}
