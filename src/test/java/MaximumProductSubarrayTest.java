import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaximumProductSubarrayTest {
    MaximumProductSubarray mps = new MaximumProductSubarray();

    @Test
    public void test1() {
        assertThat(mps.maxProduct(new int[]{2,3,-2,4}), is(6));
    }

    @Test
    public void test2() {
        assertThat(mps.maxProduct(new int[]{-2,0,-1}), is(0));
    }

    @Test
    public void test3() {
        assertThat(mps.maxProduct(new int[]{-2, 3, -4}), is(24));
    }

    @Test
    public void test4() {
        assertThat(mps.maxProduct(new int[]{3, -1, 4}), is(4));
    }

    @Test
    public void test5() {
        assertThat(mps.maxProduct(new int[]{2,-5,-2,-4,3}), is(24));
    }
}
