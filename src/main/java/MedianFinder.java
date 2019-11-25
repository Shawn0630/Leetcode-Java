import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        size++;
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (size == 0) {
            return 0;
        } else if (size % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
