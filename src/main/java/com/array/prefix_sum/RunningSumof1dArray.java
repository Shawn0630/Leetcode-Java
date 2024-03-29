package com.array.prefix_sum;

public class RunningSumof1dArray {
    // [1,2,3,4]
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];


        ans[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }

        return ans;
    }
}
