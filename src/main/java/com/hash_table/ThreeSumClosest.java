package com.hash_table;

import java.util.Arrays;

public class ThreeSumClosest {

    int minDiff = Integer.MAX_VALUE;
    int cloest;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            twoSums(nums, i + 1, nums[i], target);
        }

        return cloest;
    }

    private void twoSums(int[] nums, int cur, int sum, int target) {
        int left = cur, right = nums.length - 1;

        while (left < right) {
            int res = sum + nums[left] + nums[right];
            if (Math.abs(res - target) < minDiff) {
                minDiff = Math.abs(res - target);
                cloest = res;
            }
            if (res > target) {
                right--;
            } else if (res < target){
                left++;
            } else {
                return;
            }
        }
    }
}
