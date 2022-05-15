package com.array;

public class MissingNumber {
    // nums[nums[i]] = i;
    //index      0    1   2
    //correct    0    1   2
    //num        2    0   1

    //           i
    //                i - num[1] = 0 nums[0] = 3
    //           0     3   1
    //                 i
    //                      i
    public int missingNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int index = nums[i];
            if (index < nums.length && nums[index] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        return nums.length;
    }
}
