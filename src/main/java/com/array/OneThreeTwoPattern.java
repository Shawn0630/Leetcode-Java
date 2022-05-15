package com.array;

import java.util.Stack;

public class OneThreeTwoPattern {
    //   3,   1,  4,  2
    //  [1,  0,  1, -4, -3]
    //          [3,     5,      0,      3,      4]
    // l         3      5       0       0       0
    // h         3      5       0       3       4
    // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
    //

    // s1 < s2 > s3
    public boolean find132pattern(int[] nums) {
       Stack<Integer> stack = new Stack<>();
       int s3 = Integer.MIN_VALUE;
       for(int i = nums.length - 1; i >= 0; i--) {
           if (nums[i] < s3) {//nums[i] ==> s1
               return true;
           }
           while (!stack.empty() && nums[i] > stack.peek()) { //  s2 <= nums[i]
               s3 = stack.pop();
           }
           stack.push(nums[i]);
       }

       return false;
    }


    public boolean find132pattern2(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i]);
            for(int j = i + 1; j < nums.length; j++) {
                if (min < nums[i] && nums[i] > nums[j] && min < nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }


}
