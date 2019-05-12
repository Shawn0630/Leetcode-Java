public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int first = -1;
        int last = -1;

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    first = mid;
                    break;
                } else {
                    end = mid;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (first == -1 && nums[end] == target) {
            first = end;
        }

        start = 0;
        end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    last = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (last == - 1 && nums[end] == target) {
            last = end;
        }

        return new int[]{first, last};
    }
}
