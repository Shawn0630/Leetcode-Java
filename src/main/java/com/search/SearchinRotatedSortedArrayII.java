package com.search;
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/1161553/java-binary-search-0ms-faster-than-100
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int result =-1;
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                result =mid;
                break;
            } else if (nums[low] == nums[mid]) {
                low++;
            }
            //if first half is in increasing order
            else if(nums[low] <= nums[mid] ){
                // if target is in range of subarray
                if(target>=nums[low] && nums[mid]>=target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            //if second half is in increasing order
            else if(nums[high] > nums[mid] ){
                if(target>=nums[mid] && nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return result != -1;
    }
}
