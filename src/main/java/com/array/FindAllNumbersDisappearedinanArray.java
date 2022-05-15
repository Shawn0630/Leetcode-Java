package com.array;

import java.util.ArrayList;
import java.util.List;

// 4,3,2,7,8,2,3,1 => 1, 2, 3, 4,
// 7,3,2,4,8,2,3,1
// 3,3,2,4,8,2,7,1
// 2,3,3,4,8,2,7,1
// 3,2,3,4,8,2,7,1
// 3,2,3,4,1,2,7,8
// 1,2,3,4,3,2,7,8


public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (correctIndex >= 0 && correctIndex < nums.length && nums[correctIndex] != nums[i]) {
                swap(nums, correctIndex, i);
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                ans.add(j + 1);
            }
        }

        return ans;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (correctIndex >= 0 && correctIndex < nums.length && nums[correctIndex] != nums[i]) { // nums[correctIndex] not in correct position
                swap(nums, correctIndex, i);
            } else { // move to next pos, until nums[i] has its correct position
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                ans.add(j + 1);
            }
        }

        return ans;
    }

    // nums[i] is in the range [1, n]
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        // num[num[i] - 1] = i
        int i = 0;
        while (i < nums.length) {
            int currentIndex = nums[i] - 1;
            if (currentIndex >= 0 && currentIndex < nums.length && nums[currentIndex] != i) {
                swap(nums, i, currentIndex);
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                ans.add(j + 1);
            }
        }

        return ans;

    }


}
