package com.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        k = k % nums.length;

        rotate(nums, 0, nums.length - 1);
        rotate(nums, k, nums.length - 1);
        rotate(nums, 0, k - 1);
    }

    private void rotate(int[] nums, int first, int end) {
        if (first < 0 || end >= nums.length) {
            return;
        }

        while (first < end) {
            int temp = nums[first];
            nums[first] = nums[end];
            nums[end] = temp;
            first++;
            end--;
        }
    }
}
