package com.array;

public class MonotonicArray {
    // assumptions/constraints
    // 1. no empty array or null array
    // 1. non-strictly increasing/decreasing aka, 1, 1, 2 true
    // [1, 1, 1, 1, 1, 2] => true
    // [1] assuming true
    // [1, 1, 1, 2, 2, 3, 4, 2] false
    public boolean isMonotonic(int[] nums) {
        int state = -1; // -1: unknown, 0 increasing, 1 decreasing(strictly)

        for(int i = 1; i < nums.length; i++) {
            if (state == -1) {
                if (nums[i - 1] > nums[i]) {
                    state = 1;
                } else if (nums[i - 1] < nums[i]) {
                    state = 0;
                }
            } else if (state == 0) { // increasing
                if (nums[i - 1] > nums[i]) {
                    return false;
                }
            } else { // state == 1
                if (nums[i - 1] < nums[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
