package com.hash_table;

import java.util.HashMap;
import java.util.Map;

public class CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int count = 0;
        map.put(0l, 1);
        for (int num : nums) {
            sum += num;

            for (int j = lower; j <= upper; j++) {
                if (map.containsKey(sum - j)) {
                    count += map.get(sum - j);
                }
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
