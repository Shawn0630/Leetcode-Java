package com.array;

public class MaxConsecutiveOnes {

    //              [1,  1,  0,  1,  1,  1]
    //maxEnding      1   2   0   1
    //maxSofar       1   2   2
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxEndingAt = 0;
        int maxSofar = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxEndingAt = 0;
            } else {
                maxEndingAt += 1;
                maxSofar = Math.max(maxEndingAt, maxSofar);
            }
        }

        return maxSofar;
    }
}
