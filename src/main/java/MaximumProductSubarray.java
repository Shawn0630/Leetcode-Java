import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
           int max_prev = max[i - 1] == 0 ? 1 : max[i - 1];
           int min_prev = min[i - 1] == 0 ? 1 : min[i - 1];
           if (nums[i] > 0) {
               max[i] = max(max_prev * nums[i], nums[i]);
               min[i] = min_prev * nums[i];
           } else {
               max[i] = min_prev * nums[i];
               min[i] = min(max_prev * nums[i], nums[i]);
           }
        }


        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < max.length; i++) {
            if (ans < max[i]) {
                ans = max[i];
            }
        }

        return ans;

    }
}
