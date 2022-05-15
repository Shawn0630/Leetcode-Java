package com.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // https://leetcode.com/problems/count-of-range-sum/
    // prefix[i] - prefix[j] = k => prefix[j] = prefix[i] - k
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];

        for(int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= nums.length; j++) {
                if (sums[j] - sums[i] == k) count++;
            }
        }

        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int sum = 0;
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>(); // sum => counter
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            counter += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return counter;
    }
}
