package com.interviews.dropbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    private void combination(int[] candidates, int remain, List<Integer> cur, int curIndex) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
        }

        if (curIndex >= candidates.length) {
            return;
        }

        for(int i = curIndex; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combination(candidates, remain - candidates[i], cur, i);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum12(int[] candidates, int target) {
        res = new ArrayList<>();
        combination2(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    private void combination2(int[] candidates, int remain, List<Integer> cur, int curIndex) {
       if(remain < 0 || curIndex >= candidates.length) {
           return;
       }
       if (remain == 0) {
           res.add(new ArrayList<>(cur));
           return;
       }

        combination2(candidates, remain, cur, curIndex + 1);
        cur.add(candidates[curIndex]);
        combination2(candidates, remain - candidates[curIndex], cur, curIndex);
        cur.remove(cur.size() - 1);
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();

        combinationSum3(1, k, n, new ArrayList<>());

        return res;
    }

    private void combinationSum3(int curIndex, int k, int remain, List<Integer> cur) {
        if (curIndex > 10 || remain < 0 || cur.size() > k) {
            return;
        }

        if (remain == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
        }

        for(int i = curIndex; i <= 9; i++) {
            cur.add(i);
            combinationSum3(i + 1, k, remain - i, cur);
            cur.remove(cur.size() - 1);
        }
    }

    Integer[][] dp;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new Integer[nums.length][target + 1];

        return combinationSum4NonDup(nums, 0, target);
    }

    //  Note that different sequences are counted as different combinations.
    private int combinationSum4NonDup(int[] nums, int curIndex, int remain) {
        if (curIndex >= nums.length || remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        if (dp[curIndex][remain] != null) {
            return dp[curIndex][remain];
        }

        dp[curIndex][remain] = combinationSum4NonDup(nums, curIndex, remain - nums[curIndex])
                                + combinationSum4NonDup(nums, curIndex + 1, remain);

        return dp[curIndex][remain];
    }

    Integer[] dpDup;
    public int combinationSum42(int[] nums, int target) {
        dpDup = new Integer[target + 1];

        return combinationSum4Dup(nums, target);
    }

    private int combinationSum4Dup(int[] nums, int remain) {
        if (remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        if (dpDup[remain] != null) {
            return dpDup[remain];
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count += combinationSum4Dup(nums, remain - nums[i]);
        }
        dpDup[remain] = count;
        return dpDup[remain];
    }


}

// 1,2    4
// 1, 4 => (1, 3)
//           ->(1, 2)
//           ->(1, 1) + (2, 2)
//           ->(1, 0) + 1
//              + (2, 3)
//           ->(2, 1)
//          (2, 4)
//             ->(2, 2) + 0
//             ->(2, 0) 1