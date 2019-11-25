import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BitOperationTest {

    @Test
    public void test1() {
        assertThat(getN(0, 0), is(0));
        assertThat(getN(1, 1), is(0));
        assertThat(getN(4, 2), is(1));
        assertThat(getN(4, 0), is(0));
    }

    @Test
    public void test2() {
        assertThat(modifyN(0, 0, 1), is(1));
        assertThat(modifyN(0, 0, 0), is(0));
        assertThat(modifyN(0, 1, 1), is(2));
        assertThat(modifyN(0, 1, 0), is(0));
    }


    private int getN(int num, int n) {
        return (num >> n) & 1;
    }

    private int modifyN(int num, int n, int b) {
        int mask = 1 << n;
        return (num << n & ~mask) | (b << n & mask);
    }
}
