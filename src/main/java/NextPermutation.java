public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int descendingIndex = findFirstElementDescending(nums);
        if (descendingIndex >= 0) {
            int greaterThanIndex = findFirstElementGreaterThan(nums, nums[descendingIndex]);
            swap(nums, descendingIndex, greaterThanIndex);
        }
        reverse(nums, descendingIndex + 1, nums.length - 1);
    }

    private int findFirstElementDescending(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstElementGreaterThan(int[] nums, int num) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > num) {
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length) return;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
