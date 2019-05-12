import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(i >= k) {
                queue.remove(nums[i - k]);
            }
            queue.add(nums[i]);

            if (i >= k - 1) {
                res.add(queue.peek());
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for(Integer r: res) {
            ans[i++] = r;
        }

        return ans;

    }
}
