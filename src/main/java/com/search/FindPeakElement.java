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


    // 1 2 3 1 => 2

    // a. If num[i-1] < num[i] > num[i+1], then num[i] is peak
    //b. If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
    //c. If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
    //d. If num[i-1] > num[i] < num[i+1], then both sides have peak
    //The rule b and d can merge to one rule: if nums[i] < nums[i+1], then nums[i+1…n-1] must contains a peak element
    //The rule c and d can merge to one rule: if nums[i] > nums[i+1], then nums[0…i-1] must contains a peak element
    public int findPeakElement2(int[] nums) {

        int left = 0, right = nums.length - 1; // left = 0, right = 3

        while (left < right) { // left = 2 right = 3 left < right => true
            int mid = left + (right - left) / 2; // mid = (left + right) / 2 = 2
            if (nums[left] <= nums[mid] && nums[mid] >= nums[right]) { // grantee a peak on the left  1 2 3 => peak is not on the left side // nums[2] = 3 nums[2] = 3 nums[3] = 1
                left = mid + 1; // left = mid + 1 = 2;
            } else {
                right = mid;
            }
        }

        return left;

    }
}
