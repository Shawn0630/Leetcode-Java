import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GCDTest {

    GCD gcd = new GCD();
    @Test
    public void test1() {
        assertThat(gcd.generalizedGCD(5, new int[]{2, 4, 6, 8, 10}), is(2));
    }

    @Test
    public void test2() {
        assertThat(gcd.generalizedGCD(5, new int[]{4, 6, 2, 10, 8}), is(2));
    }

    @Test
    public void test3() {
        assertThat(gcd.generalizedGCD(5, new int[]{2, 3, 4, 5, 6}), is(1));
    }
}
