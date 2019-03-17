import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSums {
    public List<List<Integer>> twoSums(int[] nums) {
        /*
        * -2 -1 1 2 15
        *
        * */

        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int j = nums.length - 1;
        for (int i = 0; i < nums.length && i < j; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            while(i < j && nums[j] > target) j--;
            if (i < j && nums[j] == target) {
                res.add(Arrays.asList(nums[i], nums[j]));
            }
        }

        return res;

    }
}
