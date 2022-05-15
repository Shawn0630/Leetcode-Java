package com.search.binary_search;

public class FindPeakElement {
    //      1,  2,  3,  1
    //             mid
    //nums[i] != nums[i + 1] for all valid i
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // mid ~ [0, nums.length - 2]
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    //   0      1    2      3
    //  [1,     2   ,3,     1]
    //   l                  r
    //          m

    // return 2

    //  1       2       3
    //  l               r
    //          m           nums[m - 1] < num[m] < num[m + 1] => l = m + 1;

    //  1       3       2
    //  l               r
    //          m           nums[m - 1] <  num[m] > num[m + 1] => r = m

    //  3       2       1
    //  l               r
    //          m
    //                  nums[m - 1]    >    num[m] > num[m + 1] => r = m
    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
