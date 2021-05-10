package com.search;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (mid > 0 && mid < nums.length - 1 &&
                    nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
