package com.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
    // [1,2,2]
    // 0,0,0 => []
    // 0,0,1 => [2]
    // 0,1,0 => [2]  => duplicated
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new HashSet<>(), new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[] nums, int curIndex, Set<Integer> indexes, List<Integer> cur, List<List<Integer>> res) {
        if (curIndex == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (curIndex > 0 && nums[curIndex - 1] == nums[curIndex]) {
            if (indexes.contains(curIndex - 1)) {
                // add
                indexes.add(curIndex);
                cur.add(nums[curIndex]);
                dfs(nums, curIndex + 1, indexes, cur, res);

                // not add
                cur.remove(cur.size() - 1);
                indexes.remove(curIndex);
            }

        } else if (curIndex == 0 || nums[curIndex - 1] != nums[curIndex]) {
                // add
                indexes.add(curIndex);
                cur.add(nums[curIndex]);
                dfs(nums, curIndex + 1, indexes, cur, res);

                // not add
                cur.remove(cur.size() - 1);
                indexes.remove(curIndex);
        }

        dfs(nums, curIndex + 1, indexes, cur, res);
    }
}
