package com.array.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray { // three ways: one hashmap, two dp, three brute force
    //  0       1       2
    // [0,      1,      0]
    //  0       2       2

    // 1    1   1   1   0   1   1   0
    // 0    0   0   0   2   2   0   4

    // 0    1   2   3
    // 0    0   1   1
    // 0    0   0   4
    // 1    2   1   0

    // 0    -1

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int max = 0;
        // 0 = prefix - map
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i] == 0 ? 1 : -1;
            if (map.containsKey(prefix)) {
                max = Math.max(max, i - prefix);
            } else {
                map.put(prefix, i);
            }
        }


        return max;
    }
}
