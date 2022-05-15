package com.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // candidates = [2,3,6,7], target = 7
    // [[2,2,3],[7]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), 0, ans);

        return ans;
    }

    private void combinationSum(int[] candidates, int remaining, List<Integer> list, int cur, List<List<Integer>> ans) {
        if (cur >= candidates.length || remaining < 0) {
            return;
        }
        if (remaining == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[cur]);
        combinationSum(candidates, remaining - candidates[cur], list, cur, ans);
        list.remove(list.size() - 1);
        combinationSum(candidates, remaining, list, cur + 1, ans);
    }
}
