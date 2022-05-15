package com.array.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    // nums[1...i - 1] + nums[i]
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //

        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1;
            }



            // 0    1   2
            // 1    2   3
            // prefix - before  =k
            if (map.containsKey(sum - k)) {
                int length = i - map.get(sum - k);
                maxLen = Math.max(maxLen, length);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
