package com.dynamic_programming;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] length = new int[nums.length];
        int[] count = new int[nums.length];

        length[0] = 1;
        count[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int localMax = 0;
            int localCount = 1;
            for(int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    if (localMax < length[j]) {
                        localMax = length[j];
                        localCount = count[j];
                    } else if (localMax == length[j]) {
                        localCount += count[j];
                    }
                }
            }
            length[i] = localMax + 1;
            count[i] = localCount;
        }

        int longest = Integer.MIN_VALUE;
        for(int l : length) {
            longest = Math.max(longest, l);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (length[i] == longest) {
                ans += count[i];
            }
        }

        return ans;
    }
}
