import java.util.PriorityQueue;

public class KthLargest {
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int num : nums) {
            this.add(num);
        }

    }

    public int add(int val) {
        if (heap.size() < this.k) {
            heap.add(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.add(val);
        }

        return heap.peek();
    }

    private int k;
    private PriorityQueue<Integer> heap;
}
