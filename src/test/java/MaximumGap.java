public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        radixSort(nums);

        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }

        return max;
    }

    public void radixSort(int[] nums) {
        int bucketCount = 10;

        int[] aux = new int[nums.length];
        int exp = 1;

        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        while (max / exp > 0) {
            int[] bucket = new int[bucketCount];
            for(int num : nums) {
                bucket[(num / exp) % 10]++;
            }

            for(int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            for(int i = nums.length - 1; i >= 0; i--) {
                aux[--bucket[(nums[i] / exp) % 10]] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }

            exp *= 10;
        }
    }
}
