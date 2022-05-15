package com.search.binary_search;

public class SearchinRotatedSortedArrayII {

    //      0   1   2   3   4   5   6
    //      [2,  5,  6,  0,  0,  1,  2]
    //       l                       r
    //                   m
    // 0    1   2  0   0   0   0
    // l           m            r

    // 0    1   2   3


    //      0       1       2
    //      5       1       3
    //      l               r
    //              m


    //      0       1       2
    //      5       1       3
    //      l               r
    //              m
    //              r
    //      r
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        //       // to avoid duplicates
        //      while (lo < hi && nums[lo] == nums[lo + 1])
        //        ++lo;
        //      while (lo < hi && nums[hi] == nums[hi - 1])
        //        --hi;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[left] < nums[mid]) { // l -> m increasing
                if (nums[mid] < target || nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid; // in l m range
                }
            } else if (nums[mid] < nums[right]) {  // m -> r increasing
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left] == target;
    }


    public static void main(String[] args) {
        SearchinRotatedSortedArrayII searchinRotatedSortedArrayII = new SearchinRotatedSortedArrayII();
        searchinRotatedSortedArrayII.search(new int[]{5, 1, 3}, 5);
    }
}
