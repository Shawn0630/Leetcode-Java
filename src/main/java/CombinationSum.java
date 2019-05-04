import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        dp(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    private void dp(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (remain - candidates[i] >= 0) {
                    cur.add(candidates[i]);
                    dp(res, cur, candidates, i, remain - candidates[i]);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dp2(res, new ArrayList<>(), candidates, 0, target);

        return res;

    }

    private void dp2(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = index; i < candidates.length; i++) {
                if (set.contains(candidates[i])) {
                    continue;
                } else {
                    set.add(candidates[i]);
                    if (remain - candidates[i] >= 0) {
                        cur.add(candidates[i]);
                        dp2(res, cur, candidates, i + 1, remain - candidates[i]);
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dp3(res, new ArrayList<>(), k, n);
        return res;
    }

    private void dp3(List<List<Integer>> res, List<Integer> cur, int pos, int remain) {
        if (pos == 0 && remain == 0) {
            res.add(new ArrayList<>(cur));
        } else {
            int start = cur.size() == 0 ? 0 : cur.get(cur.size() - 1);
            for (int i = start + 1; i <= 9; i++) {
                if (remain - i >= 0) {
                    cur.add(i);
                    dp3(res, cur, pos - 1, remain - i);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

//    int res = 0;
//    public int combinationSum4(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        dp4(nums, target);
//
//        return res;
//    }
//
//    private void dp4(int[] nums, int remain) {
//        if (remain == 0) {
//            res++;
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (remain - nums[i] >= 0) {
//                    dp4(nums, remain - nums[i]);
//                }
//            }
//        }
//    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];

        dp[0]=1;

        for(int i=0; i<=target; i++){
            for(int num: nums){
                if(i+num<=target){
                    dp[i+num]+=dp[i];
                }
            }
        }

        return dp[target];
    }


}
