package com.dynamic_programming;

import java.util.Arrays;

public class WiggleSubsequence {

    //       1    2   4   4
    //up     1    2
    //down   1    1
    public int wiggleMaxLength(int[] nums) {
        int[] up = new int[nums.length]; // longest length with last trend up
        int[] down = new int[nums.length]; // longest length with last trend down
        up[0] = 1;
        down[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]){
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }


    public int wiggleMaxLength2(int[] nums) {
        int[] up = new int[nums.length]; // longest length ending at x last trend up
        int[] down = new int[nums.length]; // longest length ending at x last trend down

        up[0] = 1;
        down[0] = 1;
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }

            max = Math.max(up[i], down[i]);
        }

        return max;
    }
}
