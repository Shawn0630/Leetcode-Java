package com.search.binary_search;

public class SearchinRotatedSortedArray {
    //          0    1   2   3   4   5   6
    //          4,   5,  6,  7,  0,  1,  2
    //          l            m           r
    //                           l   m   r
    //          1    3
    //          l    r
    //          m

    //      5,      1,      3
    //      l       m       r
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // [0, nums.length - 1]
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid] && (nums[mid] < target || target < nums[left]) ||
                      (nums[left] > nums[mid] && (nums[mid] > target || target > nums[left]))) { // 3(l)...4(mid)....5...1(r)...2
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }

    //      0       1       2       3       4       5       6
    //      4,      5,      6,      7,      0,      1,      2
    //      l                                               r
    //                              m
    //                                      l               r
    //                                              m
    // always have at least a half in increasing direction

    // [    3,      1]
    //      l       r
    //      m
    // 1
    public int search2(int[] nums, int target) {

        int left = 0, right = nums.length - 1;


        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]) { // left side increasing
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1; // target on right half
                } else {
                    right = mid;
                }
            } else { // right half increasing
                if (target < nums[mid] || target > nums[right]) {
                    right = mid; // target on the left half
                } else {
                    left = mid + 1;
                }
            }
        }

        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray searchinRotatedSortedArray = new SearchinRotatedSortedArray();
        searchinRotatedSortedArray.search2(new int[]{4,5,6,7,0,1,2}, 0);
    }
}
