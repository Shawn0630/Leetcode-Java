package com.array.prefix_sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum {
    // (b - a) mod k = 0 => [(b mod k) - (a mod k)] mod k = 0 => b mod k = a mod k
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);


        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2)
                return true;
            } else {
                map.put(mod, i);
            }
        }

        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
       for(int i = 1; i <= nums.length; i++) {
           sums[i] = sums[i - 1] + nums[i - 1];
       }

       //           1     2     3     4       5
       //sum   0    1     3     6     10      15
       for(int i = 0; i <= nums.length; i++) {
           for(int j = i + 2; j <= nums.length; j++) {
               int cur = sums[j] - sums[i];
               if (cur % k == 0) {
                   return true;
               }
           }
       }

       return false;
    }
}
