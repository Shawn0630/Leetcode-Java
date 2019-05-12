import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SubProductLessthanKTest {
    SubProductLessthanK splk = new SubProductLessthanK();

    @Test
    public void test1() {
        assertThat(splk.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100), is(8));
    }

    @Test
    public void test2() {
        assertThat(splk.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0), is(0));
    }

    @Test
    public void test3() {
        assertThat(splk.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1), is(0));
    }
}
