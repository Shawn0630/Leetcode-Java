public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int index = 0;

        while (p1 < nums.length && p2 < nums.length) {
            if (nums[p1] == nums[p2]) {
                if (p2 - p1 < 2) {
                    nums[index++] = nums[p2++];
                } else {
                    p2++;
                }
            } else {
                p1 = p2;
            }
        }

        return index;
    }
}
