package com.dynamic_programming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for(int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] == Integer.MIN_VALUE) dp[i] = 1;
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }

    //
    // [10,     9,      2,      5,      3,      7,      101,        18]
    //  1       1       1       2       2       3       4           3

    // subsequence => mono stack
    //
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;

        int maxLen = 0;
        for(int i = 1; i < nums.length; i++) {
            int max = 0;
            for(int j = i - 1; j >=0; j--) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    //
    // [10,     9,      2,      5,      3,      7,      101,        18]
    //
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74897/Fast-Java-Binary-Search-Solution-with-detailed-explanation
    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxLen = 1;

        for(int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp, maxLen, nums[i]);
            if(pos >= maxLen) {
                dp[pos] = nums[i];
                maxLen++;
            } else if(dp[pos] > nums[i]){
                dp[pos] = nums[i];
            }
        }

        return maxLen;
    }

    private int binarySearch(int[] dp, int maxLen, int num) {
        int left = 0;
        int right = maxLen;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] == num) {
                return mid;
            } else if (dp[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
    // if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and
    // if the input array is {10, 5, 4, 3}, then output should be 10

    public int lengthOfLISum(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxLen = 1;

        for(int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp, maxLen, nums[i]);
            if(pos >= maxLen) {
                dp[pos] = nums[i];
                maxLen++;
            } else if(dp[pos] > nums[i]){
                dp[pos] = nums[i];
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        longestIncreasingSubsequence.lengthOfLIS3(new int[]{10,9,2,5,3,7,101,18});
    }
}
