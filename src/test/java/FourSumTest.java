import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FourSumTest {

    FourSum fs = new FourSum();

    @Test
    public void test1() {
        assertThat(fs.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0), containsInAnyOrder(
                Arrays.asList(-1,  0, 0, 1),
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2,  0, 0, 2)));
    }

    @Test
    public void test2() {
        assertThat(fs.fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9), containsInAnyOrder(
            Arrays.asList(-5,-4,-1,1),
            Arrays.asList(-5,-4,0,0),
            Arrays.asList(-5,-2,-2,0),
            Arrays.asList(-4,-2,-2,-1)
        ));
    }

    @Test
    public void test3() {
        assertThat(fs.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}), is(2));
    }

    @Test
    public void test4() {
        assertThat(fs.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}), is(1));
    }
}
