import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, nums, 0);
        return res;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
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
            helper(res, nums, pos + 1);
            lastJs.add(nums[pos]);
            for (int i = pos; i < nums.length; i++) {
                if (nums[i] != nums[pos] && !lastJs.contains(nums[i])) {
                    swap(nums, pos, i);
                    lastJs.add(nums[pos]);
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
