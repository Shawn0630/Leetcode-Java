import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SlidingWindowMedianTest {

    SlidingWindowMedian swm = new SlidingWindowMedian();

    @Test
    public void test1() {
        assertThat(swm.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3), is(new double[]{1,-1,-1,3,5,6}));
    }

    @Test
    public void test2() {
        assertThat(swm.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4), is(new double[]{2.5}));
    }

    @Test
    public void test3() {
        assertThat(swm.medianSlidingWindow(new int[]{2147483647,2147483647}, 2), is(new double[]{2147483647}));
    }

    @Test
    public void test4() {
        assertThat(swm.medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3),
                is(new double[]{-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,-2147483648.0}));
    }

    @Test
    public void testPriority() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.remove(1);
        System.out.println(priorityQueue);
    }
}
