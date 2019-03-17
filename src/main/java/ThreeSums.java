import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public List<List<Integer>> threeSums(int[] nums) {

        Arrays.sort(nums);

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int low = i + 1; int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
