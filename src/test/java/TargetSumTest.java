import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TargetSumTest {
    TargetSum ts = new TargetSum();

    @Test
    public void test1() {
        assertThat(ts.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3), is(5));
    }
}
