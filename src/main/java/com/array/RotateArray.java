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



    //  0   1   2   3   4   5   6
    //  5   6   7   1   2   3   4
    // [1,  2,  3,  4,  5,  6,  7]
    //  l               r
    //      l               r
    //          l               r

    //  5   6   7   4   1   2   3
    //              l

    // 5    6   1   2   3   4
    // l                     r
    //      l           r
    //          l   r

    // 4    3   2   1   6   5
    // 1    2   3   4
    // nums = [1,2,3,4,5,6,7], k = 3
    // 5    6   7   1   2   3   4
    //
    public void rotate2(int[] nums, int k) {
        int off = k % nums.length; // 3 % 7 = 3
        int start = nums.length - off; // 7 - 3

        int left = 0;
        int right = start;

        // moving to the front
        while (right < nums.length) {
            swap(nums, left, right);
            left++;
            right++;
        }

        right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

        right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length ||
            j < 0 || j >= nums.length) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
