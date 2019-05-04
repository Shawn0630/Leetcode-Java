import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MissingNTest {
    @Test
    public void test1() {
        assertThat(MissingN.findMissing(Arrays.asList(1, 5), Arrays.asList(1)), is(5));
    }

    @Test
    public void test2() {
        assertThat(MissingN.findMissing(Arrays.asList(5, 12, 17, 3, 1), Arrays.asList(12, 17, 3, 5)), is(1));
    }

    @Test
    public void test3() {
        assertThat(MissingN.findMissing(Arrays.asList(-5, 12, 17, 3, 1), Arrays.asList(12, 17, 3, -5)), is(1));
    }

    @Test
    public void test4() {
        assertThat(MissingN.findMissing(Arrays.asList(-5, 12, 17, 3, 1), Arrays.asList(12, 17, 3, 1)), is(-5));
    }

    @Test
    public void test5() {
        assertThat(MissingN.findMissing(Arrays.asList(-5, -1, 17, 3, 1), Arrays.asList(-1, 17, 3, 1)), is(-5));
    }

    @Test
    public void test6() {
        assertThat(MissingN.findMissing(Arrays.asList(0, -5, -1, 17, 3, 1), Arrays.asList(-1, 17, 3, 1, -5)), is(0));
    }
}
