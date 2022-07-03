package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        combinationDFS(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void combinationDFS(int[] candidate, int target, int index, List<Integer> cur) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (index >= candidate.length) {
            return;
        }

        cur.add(candidate[index]);
        combinationDFS(candidate, target - candidate[index], index, cur);
        cur.remove(cur.size() - 1);
        combinationDFS(candidate, target, index + 1, cur);
    }

    private void combinationDFS2(int[] candidate, int target, int index, List<Integer> cur) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (index >= candidate.length) {
            return;
        }

        for(int i = index; i < candidate.length && candidate[i] <= target; i++) {
            cur.add(candidate[i]);
            combinationDFS2(candidate, target - candidate[i], i, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        //combinationSum2DFS(candidates, 0, target, new ArrayList<>(), new HashSet<>());
        combinationSum2DFS2(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void combinationSum2DFS(int[] candidates, int curIndex, int remaining, List<Integer> cur, Set<Integer> added) {
        if (remaining == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (curIndex >= candidates.length) {
            return;
        }

        if (curIndex > 0 && candidates[curIndex - 1] == candidates[curIndex] && !added.contains(curIndex - 1)) {
            combinationSum2DFS(candidates, curIndex + 1, remaining, cur, added);
        } else {
            cur.add(candidates[curIndex]);
            added.add(curIndex);
            combinationSum2DFS(candidates, curIndex + 1, remaining - candidates[curIndex], cur, added);
            cur.remove(cur.size() - 1);
            added.remove(curIndex);
            combinationSum2DFS(candidates, curIndex + 1, remaining, cur, added);
        }
    }

    private void combinationSum2DFS2(int[] candidates, int curIndex, int remaining, List<Integer> cur) {
        if (remaining == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int i = curIndex; i < candidates.length && candidates[i] <= remaining; i++) {
            if (i > curIndex && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            combinationSum2DFS2(candidates, i + 1, remaining - candidates[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
