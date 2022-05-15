package com.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    // https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/1300906/Java-Solution-with-Explanation
    // (prefix[j] - prefix[i]) % k = 0 =>
    // (prefix[j] % k - prefix[i] % k) % k = 0
    // sum % k = prefix[i] % k
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>(); // sum => frequency
        map.put(0, 1);



        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k < 0? sum % k + k : sum % k;
            counter += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return counter;
    }
}
