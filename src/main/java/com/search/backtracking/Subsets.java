package com.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // constraints/assumptions
    // 1. nums contains unique numbers
    // 2. no empty array or null array
    // 3. return result in any order
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, 0, ans, new ArrayList<>());

        return ans;
    }

    public void subsets(int[] nums, int cur, List<List<Integer>> ans, List<Integer> list) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        subsets(nums, cur + 1, ans, list);
        list.remove(list.size() - 1);
        subsets(nums, cur + 1, ans, list);
    }
}
