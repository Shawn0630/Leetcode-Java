public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result[i - 1] <= 0) {
                result[i] = nums[i];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }

        return max;
    }
}
