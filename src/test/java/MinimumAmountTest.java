import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MinimumAmountTest {

    @Test
    public void test1() {
        assertThat(MinimumAmount.calculateAmount(Arrays.asList(4, 9, 2, 3)), is(10L));
    }

    @Test
    public void test2() {
        assertThat(MinimumAmount.calculateAmount(Arrays.asList(1, 2, 3, 4)), is(7L));
    }

}
