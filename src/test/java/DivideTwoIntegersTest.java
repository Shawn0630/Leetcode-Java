import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DivideTwoIntegersTest {
    DivideTwoIntegers dti = new DivideTwoIntegers();

    @Test
    public void test1() {
        assertThat(dti.divide(10, 3), is(3));
    }

    @Test
    public void test2() {
        assertThat(dti.divide(7, -3), is(-2));
    }
}
