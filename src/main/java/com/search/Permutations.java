package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, nums, 0);
//        Arrays.sort(nums);
//        permute(res, nums, new int[nums.length], new boolean[nums.length], 0);
        return res;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
    }

    /**
     * Refer to https://zhuanlan.zhihu.com/p/126081997
     */
    private void permute(List<List<Integer>> res, int[] nums, int[] r, boolean[] flag, int cur) {
        if (cur == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : r) {
                temp.add(num);
            }
            res.add(temp);
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) continue;
                flag[i] = true;
                r[cur] = nums[i];
                permute(res, nums, r, flag, cur + 1);
                flag[i] = false;
            }
        }
    }

    private void helper(List<List<Integer>> res, int[] nums, int pos) {
        /*
        *
        * 2, 2, 1, 1
        * =>
        *   2| 2, 1, 1
        *     =>
        *     2, 2| 1, 1
        *         =>
        *         2, 2, 1| 1 (1)
        *     2, 1| 2, 1
        *         =>
        *         2, 1, 2| 1 (2)
        *         2, 1, 1| 2 (3)
        *   1| 2, 2, 1
        *     =>
        *     1, 2| 2, 1
        *         =>
        *         1, 2, 2|1 (4)
        *         1, 2, 1|2 (5)
        *     1, 1| 2, 2
        *         =>
        *         1, 1, 2| 2 (6)
        *
        * */
        if (pos == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                temp.add(nums[i]);
            }
            res.add(temp);
        } else {
            List<Integer> lastJs = new ArrayList<Integer>();
            lastJs.add(nums[pos]);
            helper(res, nums, pos + 1);
            for (int i = pos + 1; i < nums.length; i++) {
                if (!lastJs.contains(nums[i])) {
                    lastJs.add(nums[i]);
                    swap(nums, pos, i);
                    helper(res, nums, pos + 1);
                    swap(nums, pos, i);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
