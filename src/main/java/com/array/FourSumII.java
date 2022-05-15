package com.array;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourSumII {

    // LTE
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int counter = 0;
        for(int i = 0; i < nums1.length; i++) {
            counter += threeSum(nums2, nums3, nums4, 0 - nums1[i]);
        }

        return counter;
    }

    private int threeSum(int[] nums1, int[] nums2, int[] nums3, int target) {
        int counter = 0;

        for(int i = 0; i < nums1.length; i++) {
            counter += twoSum(nums2, nums3, target - nums1[i]);
        }

        return counter;
    }

    private int twoSum(int[] nums1, int[] num2, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(target - nums1[i], map.getOrDefault(target - nums1[i], 0) + 1);
        }

        // nums1 + nums2 = target
        //
        int counter = 0;
        for(int i = 0; i < num2.length; i++) {
            counter += map.getOrDefault(num2[i], 0);
        }

        return counter;
    }


    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int k : nums1) {
            for (int i : nums2) {
                map.put(k + i, map.getOrDefault(k + i, 0) + 1);
            }
        }
        int counter  = 0;

        for(int num3: nums3) {
            for(int num4 : nums4) {
                counter += map.getOrDefault(-num3 - num4, 0);
            }
        }

        return counter;
    }
}
