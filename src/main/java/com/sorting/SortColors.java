package com.sorting;

public class SortColors {
    // https://leetcode.com/problems/sort-colors/discuss/1537261/Easy-or-One-pass-or-solution-or-Java
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] freq = new int[3];
        for(int num : nums) {
            freq[num]++;
        }

        int idx = 0;
        for(int i = 0; i < freq.length; i++) {

            while (freq[i] > 0) {
                nums[idx++] = i;
                freq[i]--;
            }
        }

        return;
    }
}
