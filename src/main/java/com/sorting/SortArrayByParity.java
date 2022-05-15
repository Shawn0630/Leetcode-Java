package com.sorting;

public class SortArrayByParity {

    //      0   1   2   3
    //      [3,  1,  2,  4]
    // even
    public int[] sortArrayByParity(int[] nums) {
        int evenIdx = 0;
        for(int i = 0; i < nums.length; i++) {// iterator to loop through the array
            if (nums[i] % 2 == 0) {
                int temp = nums[evenIdx];
                nums[evenIdx] = nums[i];
                nums[i] = temp;
                evenIdx++;
            }
        }

        return nums;
    }
}
