import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);
            dfs(res, cur, i + 1, nums);
        }
        res.add(Collections.emptyList());

        return res;

    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> ans = new ArrayList<>(cur);
            res.add(ans);
        } else {
            cur.add(nums[index]);
            dfs(res, cur, index + 1, nums);
            cur.remove(cur.size() - 1);
            dfs(res, cur, index + 1, nums);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfsWithDuplication(res, new ArrayList<>(), 0, nums);

        return res;
    }

    private void dfsWithDuplication(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
       res.add(new ArrayList<>(cur));
       for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            dfsWithDuplication(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
       }
    }

}
