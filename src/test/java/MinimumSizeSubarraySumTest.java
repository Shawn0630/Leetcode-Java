import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MinimumSizeSubarraySumTest {
    MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();

    @Test
    public void test1() {
        assertThat(msss.minSubArrayLen(7, new int[]{2,3,1,2,4,3}), is(2));
    }

    @Test
    public void test2() {
        assertThat(msss.minSubArrayLen(4, new int[]{1, 4, 4}), is(1));
    }

    @Test
    public void test3() {
        assertThat(msss.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}), is(3));
    }
}
