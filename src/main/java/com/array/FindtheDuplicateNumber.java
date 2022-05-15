package com.array;

import java.util.Arrays;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) >> 1;
            if(mid > 0 && nums[mid] == nums[mid -1]){ // if mid element is duplicate
                return nums[mid];
            }else if(mid + 1 < nums.length && nums[mid] == nums[mid + 1]) { // if mid element is duplicate.
                return nums[mid];
            } else if (nums[mid] >= mid + 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            // current nums not at the right pos
            if (correctIndex >= 0 && correctIndex < nums.length && nums[correctIndex] != nums[i] ) {
                swap(nums, correctIndex, i);
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }

        return -1;
    }


    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
