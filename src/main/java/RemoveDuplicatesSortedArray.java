public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int cur = 0;

        while(cur < nums.length) {
            nums[count++] = nums[cur++];
            while (cur < nums.length && nums[cur] == nums[cur - 1]) cur++;
        }

        return count;

    }
}
