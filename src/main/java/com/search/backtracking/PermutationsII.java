package com.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 1 3 2 => 1 2 3, avoid finding duplicates

        ans = new ArrayList<>();
        permuteHelper(nums, new HashSet<>(), new ArrayList<>());

        return ans;
    }

    // 1    1   2

    // 1    1   2
    // 1    2   1
    // 2    1   1
    private void permuteHelper(int[] nums, Set<Integer> set, List<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = 0; i < nums.length; i++) { // use a number if and only if the previous element is being used when there is duplicates digits
            if (!set.contains(i)) { // always pick the first one // 1  1  2   => picked the first 1   //  1  2  2 // picked the first 2
                if (i > 0 && nums[i - 1] == nums[i] && !set.contains(i - 1))continue;
                res.add(nums[i]);
                set.add(i);
                permuteHelper(nums, set, res);
                res.remove(res.size() - 1); // backtracking
                set.remove(i);
            }
        }
    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums); // 1 3 2 => 1 2 3, avoid finding duplicates
        List<List<Integer>> ans = new ArrayList<>();

        permuteUniqueHelper2(nums, new ArrayList<>(), ans, new HashSet<>());

        return ans;
    }

    private void permuteUniqueHelper2(int[] nums, List<Integer> cur, List<List<Integer>> ans, Set<Integer> added) {
        if(cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                // 1, 1, 3
                if (added.contains(i - 1) && !added.contains(i)) {
                    added.add(i);
                    cur.add(nums[i]);
                    permuteUniqueHelper2(nums, cur, ans, added);
                    cur.remove(cur.size() - 1);
                    added.remove(i);
                }
            } else {
                if (!added.contains(i)) {
                    added.add(i);
                    cur.add(nums[i]);
                    permuteUniqueHelper2(nums, cur, ans, added);
                    cur.remove(cur.size() - 1);
                    added.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();

        permutationsII.permuteUnique(new int[]{1, 1, 2});
    }
}
