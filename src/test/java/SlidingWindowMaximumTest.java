import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SlidingWindowMaximumTest {

    SlidingWindowMaximum swm = new SlidingWindowMaximum();

    @Test
    public void test1() {
        assertThat(swm.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3), is(new int[]{3,3,5,5,6,7}));
    }
}
