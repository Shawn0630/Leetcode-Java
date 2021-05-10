public class SearchinRotatedSortedArray {
//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//
//        int left = 0;
//        int right = nums.length - 1;
//
//        // edge case: [1]
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[left] <= nums[mid]) {
//                if (nums[mid] > target && nums[left] <= target) {
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            } else {
//                if (nums[mid] < target && target <= nums[right]) {
//                    left = mid + 1;
//                } else {
//                    right = mid;
//                }
//            }
//        }
//
//        return nums[left] == target ? left : -1;
//    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;


        while (low <= high) {
            int mid = (low + high) >> 1;

            if (nums[mid] == target) {
                return mid;
            } else if ((nums[mid] < target && nums[high] < target) ||
                    (nums[mid] > target && nums[low] <= target)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
