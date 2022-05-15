package com.search.binary_search;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int left = min, right = max;

        // the first element with count of greater element larger than k
        // 1    2   3   4   5   k = 1
        // 0
        while (left < right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for(int num : nums) {
                if (num > mid) count++;
            }

            if (count >= k) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }
}
