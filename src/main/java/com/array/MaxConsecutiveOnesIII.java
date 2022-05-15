package com.array;

public class MaxConsecutiveOnesIII {


    //      1,   1,  1,  0,  0,  0,  1,  1,  1,  1,  0
    // k
    public int longestOnes(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k + 1];

        for(int i = 0; i <= k; i++) {
            dp[0][i] = 0;
        }

        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = k; j > 0; j--) {
                dp[i + 1][k] = nums[i] == 0 ? dp[i][k - 1] + 1 : dp[i][k] + 1;
            }
            max = Math.max(dp[i + 1][k], max);
        }

        return max;
    }

    public int longestOnes2(int[] nums, int k) {
        int left = 0, right = 0;

        int remainK = k;
        int ans = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
            } else {
                if (remainK > 0) {
                    right++;
                    remainK--;
                } else {
                   if (nums[left] == 0) {
                       remainK++;
                   }
                   left++;
                }
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }

}
