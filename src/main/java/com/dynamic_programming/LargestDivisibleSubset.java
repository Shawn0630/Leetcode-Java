package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    // https://leetcode.com/problems/largest-divisible-subset/discuss/1579023/JAVA-EASY-SOLUTION-DP-%2B-SORTING
    // https://leetcode.com/problems/largest-divisible-subset/discuss/1579055/Similar-to-print-LIS-Java-Code-Intutive-and-Visualization
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] prev = new int[nums.length];
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            prev[i] = -1;
            dp[i] = 1;
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        prev[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int curIndex = maxIndex;
        while (curIndex != -1) {
            ans.add(nums[curIndex]);
            curIndex = prev[curIndex];
        }

        return ans;
    }
}
