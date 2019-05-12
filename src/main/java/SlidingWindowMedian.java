import java.util.*;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        List<Double> medium = new ArrayList<>();

        // maxHeap on the left, minHeap on the right, get medium in the max heap
        // maxHeap descending, minHeap asceding
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (maxHeap.peek() < nums[i - k]) {
                    minHeap.remove(nums[i - k]);
                } else {
                    maxHeap.remove(nums[i - k]);
                }
            }
            if (!minHeap.isEmpty() && nums[i] > minHeap.peek()) {
                minHeap.offer(nums[i]);
            } else {
                maxHeap.offer(nums[i]);
            }

            while (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            if (i >= k - 1) {
                if (k % 2 == 0) {
                    medium.add(((double)minHeap.peek() + (double)maxHeap.peek()) / (double)2);
                } else {
                    medium.add((double)maxHeap.peek());
                }
            }
        }

        double[] ans = new double[medium.size()];
        int i = 0;
        for(double d : medium) {
            ans[i++] = d;
        }

        return ans;

    }
}
