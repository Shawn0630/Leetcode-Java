package com.search.binary_search;

public class CheckIfaNumberIsMajorityElementinaSortedArray {
    // https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/discuss/355389/Java-Binary-search-O(log(n))-time
    // https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/discuss/1754470/Java-0ms-easy-to-understand-solution.-Beats-100
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/702162/python-lets-implement-pythons-bisect-algorithm

    //   def bisect_left(self, a, x):
    //		'''returns i where all a[:i] is less than x'''
    //        lo, hi = 0, len(a)
    //        while lo < hi:
    //            mid = lo + (hi - lo) // 2
    //            if a[mid] < x: lo = mid + 1
    //            else: hi = mid
    //        return lo
    //
    //    def bisect_right(self, a, x):
    //		'''returns i where all a[:i] is less than or equal to x'''
    //        lo, hi = 0, len(a)
    //        while lo < hi:
    //            mid = lo + (hi - lo) // 2
    //            if a[mid] > x: hi = mid
    //            else: lo = mid + 1
    //        return lo
    public boolean isMajorityElement(int[] nums, int target) {
        int low = 0,high = nums.length-1,mid = 0;
        int highest = -1,lowest = -1;


        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                highest = mid;
                low = mid + 1;
            }else if(nums[mid] > target) high = mid;
            else low = mid + 1;
        }

        if(highest == -1) return false;

        low = 0;high = nums.length-1;

        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                lowest = mid;
                high = mid;
            }else if(nums[mid] > target) high = mid;
            else low = mid + 1;
        }

        return highest - lowest + 1 > nums.length / 2;
    }

    private int[] getLocs(int target, int[] nums) {
        int left = 0, right = nums.length - 1;


        /**
         * The lower and upper bound of a binary search are the lowest and highest position where the value could be inserted without breaking the ordering. (In the C++ standard library, these bounds will be represented by iterators referencing the element before which the value could be inserted, but the concept is not essentially changed.)
         *
         * Take, for example, a sorted range
         *
         * 1 2 3 4 5 5 5 6 7 9
         * In a binary search for 3, we will have
         *
         *    v-- lower bound
         * 1 2 3 4 5 5 5 6 7 9
         *      ^-- upper bound
         * And in a binary search for 5:
         *
         *        v-- lower bound
         * 1 2 3 4 5 5 5 6 7 9
         *              ^-- upper bound
         * The lower and upper bound are the same if the element does not exist in the range. In a binary search for 8:
         *
         *                  v-- lower bound
         * 1 2 3 4 5 5 5 6 7 9
         *                  ^-- upper bound
         * The author of the article to which you refer phrases all this in the equivalent terms of "smaller than" and "greater than" so that in a search of 5,
         *
         *        v-- lower bound
         * t t t t f f f f f f      <-- smaller than?
         * 1 2 3 4 5 5 5 6 7 9
         * f f f f f f f t t t      <-- greater than?
         *              ^-- upper bound
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    right = right - 1;
                } else {
                    break;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int low = nums[left] == target ? left : -1;


        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    left = left + 1;
                } else {
                    break;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int high = nums[left] == target ? left : -1;

        return new int[]{low, high};
    }

    public static void main(String[] args) {
        CheckIfaNumberIsMajorityElementinaSortedArray checkIfaNumberIsMajorityElementinaSortedArray = new CheckIfaNumberIsMajorityElementinaSortedArray();
        checkIfaNumberIsMajorityElementinaSortedArray.isMajorityElement(new int[]{2, 5, 5}, 5);
    }
}
