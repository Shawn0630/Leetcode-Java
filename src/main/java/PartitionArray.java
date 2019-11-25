public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
       if (nums == null) {
           return -1;
       }

       int left = 0;
       int right = nums.length - 1;
       int pos = 0;

       // TODO: handle []
       while (left < right) {
           /* 0    1    2   3
           *  3    2    2   1
           *      mid
           *
           * */
           pos = swap(nums, left, right);
           if (nums[pos] >= k) {
               return pos;
           } else {
               left = pos + 1;
           }
       }

       return pos;
    }


    private int swap(int[] nums, int left, int right) {
       int pivot = nums[left];

       while (left < right) {
           while (left < right && pivot <= nums[right]) right--;
           nums[left] = nums[right];
           while (left < right && pivot >= nums[left]) left++;
           nums[right] = nums[left];
       }
       nums[left] = pivot;
       return left;
    }
}
