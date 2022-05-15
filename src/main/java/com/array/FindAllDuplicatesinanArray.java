package com.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        int n = nums.length;
        int i = 0;
        while(i < n) {
            int correctIndex = nums[i] - 1;
            if (correctIndex >= 0 && correctIndex < n && nums[correctIndex] != nums[i]) {
                swap(nums, correctIndex, i);
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(nums[j]);
            }
        }

        return ans;
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
