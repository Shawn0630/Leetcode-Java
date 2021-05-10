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
}
