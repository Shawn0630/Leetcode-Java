package com.array;

public class MinimumValuetoGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int min = 1;
        int cur = 1;

        for(int i = 0; i < nums.length; i++) {
            if (cur + nums[i] < 1) {
                min += Math.abs(1 - (cur + nums[i]));
                cur = 1;
            } else {
                cur += nums[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumValuetoGetPositiveStepbyStepSum minimumValuetoGetPositiveStepbyStepSum = new MinimumValuetoGetPositiveStepbyStepSum();
        minimumValuetoGetPositiveStepbyStepSum.minStartValue(new int[]{-3,2,-3,4,2});
    }
}
