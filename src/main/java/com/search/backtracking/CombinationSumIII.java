package com.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumBackTracking(k, n, 1, new ArrayList<>(), res);

        return res;
    }

    private void combinationSumBackTracking(int k, int n, int index, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        if (n < 0) {
            return;
        }
        if (cur.size() > k) {
            return;
        }

        for(int i = index; i <= 9; i++) {
            cur.add(i);
            combinationSumBackTracking(k, n - i, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }


    List<List<Integer>> result;
    public List<List<Integer>> combinationSum32(int k, int n) {
        result = new ArrayList<>();
        combinationSumDFS(k, n, new ArrayList<>(), 1);
        return result;
    }

    private void combinationSumDFS(int remainK, int remainN, List<Integer> ans, int cur) {
        if (remainK < 0 || remainN < 0) {
            return;
        }

        if (remainN == 0 && remainK == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i = cur; i <= 9; i++) {
            ans.add(i);
            combinationSumDFS(remainK - 1, remainN - i, ans, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
