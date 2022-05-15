package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    // [0, 0, 0]
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> twoSumsList = twoSums(nums, i + 1, -nums[i]);
            if (twoSumsList.size() != 0) {
                for (List<Integer> twoSum : twoSumsList) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.addAll(twoSum);
                    ans.add(result);
                }
            }
        }


        return ans;
    }

    private static List<List<Integer>> twoSums(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = start, j = nums.length - 1;
        while (i < j) {
            if (i > start && nums[i] == nums[i - 1]) {
                i++;
                continue;
            };
            int remaining = target - nums[i];
            if(remaining == nums[j]) {
                ans.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            } else if (remaining < nums[j]) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        threeSum(new int[]{0, 0, 0});
    }
}
