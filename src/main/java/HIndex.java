public class HIndex {

    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0) {
            return 0;
        }

        int start = 0;
        int end = citations.length - 1;
        int max = 0;
        if (citations.length == 1) {
            return citations[0] < 1 ? 0 : 1;
        }

        while (start < end) {
            int mid = sort(citations, start, end);
            if (citations.length - mid >= citations[mid]) {
               start = mid + 1;
               max = mid + 1;
            } else {
                end = mid;
            }
        }

        return citations.length - end >= citations[end] ? end : max;
    }

    private int sort(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) start++;
            nums[end] = nums[start];
        }
        nums[start] = pivot;

        return start;
    }
}
