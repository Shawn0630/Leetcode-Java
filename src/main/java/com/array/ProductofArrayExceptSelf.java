package com.array;

public class ProductofArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/discuss/1342916/3-Minute-Read-Mimicking-an-Interview
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        lefts[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            lefts[i] = lefts[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            lefts[i] = right * lefts[i];
            right = right * nums[i];
        }

        return lefts;
    }
}
