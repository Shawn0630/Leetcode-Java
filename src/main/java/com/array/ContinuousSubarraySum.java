package com.array;

public class ContinuousSubarraySum {
    //https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
    // (a + b) mod d = (a mod d + b mod d) mod d
    // pitfall: missing some prefix sum
    //  in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0].
    //  We got remainder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number which is multiple of the k. Hope this clarifies your doubt :)
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        // 0 1 2
        // 2 ~ 0
        for(int i = 0; i < nums.length; i++) {
            for(int j = -1; j < i - 1; j++) {
                int sum;
                if (j == -1) {
                    sum = sums[i];
                } else {
                    sum = sums[i] - sums[j];
                }
                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
