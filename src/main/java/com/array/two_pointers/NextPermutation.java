package com.array.two_pointers;

public class NextPermutation {
    // https://leetcode.com/problems/next-permutation/discuss/825963/Simple-java-solution-with-explaination0ms100-faster-o(n)-time
    // https://leetcode.com/problems/next-permutation/discuss/1510520/Next-Permutation-100-faster-or-Java-Solution
    // 1 2 3 4
    // 1 3 2 4
    // 1 3 4 2
    // 1 4 2 3 step one: find if next greater element exists via searching element from right to left until elements are increasing.
    // 1 4 3 2   if indexes reach one(4 3 2 1), reverse the entire array
    //           else find the element from left to right till index whose value is greater than element present at index
    // ...
    // 4 3 2 1 goal is decreasing order => 1 2 3 4
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) j--; // first element greater from right to left than value at index i
        swap(nums, j, i);
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length ||
                j < 0 || j >= nums.length) {
            return;
        }

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length ||
            j < 0 || j >= nums.length) {
            return;
        }

        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }


    // 1    2   3   4
    // 1    2   4   3    find the first decrease loc from right to left
    //                   find the first number greater than the selected element
    //  .
    //  .
    // 4    3   2   1
    public void nextPermutation2(int[] nums) {
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) left--;
        if (left < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int right = nums.length - 1;
        while (left < right && nums[left] >= nums[right]) right--;
        if (left != right) {
            swap(nums, left, right);
        }
        reverse(nums, left + 1, nums.length - 1);

        return;
    }
}
