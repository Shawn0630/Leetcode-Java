package com.search;

// 4   ,5,6,  7,   0,     1,    4
// left     mid      right
//                 left   mid  right
//           left  mid          right


// 3,      3,   1,      3
// left   mid          right


// 1,      3,        5
// left    mid        right


// 1,   3
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[left] < nums[mid] && nums[mid] > nums[right]) { // breakpoint on right
                left = mid + 1;
            } else if(nums[left] > nums[mid] && nums[mid] < nums[right]) { // breakpoint on left
                right = mid;
            } else if (nums[right - 1] < nums[right]) { // right is not the min
                right--;
            } else {
                left++;
            }
        }

        return nums[left];

    }
}
