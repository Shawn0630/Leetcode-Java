package com.merge_sort;

public class SortanArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return(nums);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) >> 1;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] helper = new int[high - low + 1];
        for(int i = low; i <= high; i++) {
            helper[i - low] = nums[i];
        }

        int i = low, j = mid + 1;
        int idx = low;

        while (i <= mid && j <= high) {
            if (helper[i - low] < helper[j - low]) {
                nums[idx++] = helper[i++ - low];
            } else {
                nums[idx++] = helper[j++ - low];
            }
        }

        while (i <= mid) {
            nums[idx++] = helper[i++ - low];
        }
    }
}
