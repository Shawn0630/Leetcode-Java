import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HIndexTest {

    HIndex hi = new HIndex();

    @Test
    public void test1() {
        assertThat(hi.hIndex(new int[]{3,0,6,1,5}), is(3));
    }

    @Test
    public void test2() {
        assertThat(hi.hIndex(new int[]{0}), is(0));
    }

    @Test
    public void test3() {
        assertThat(hi.hIndex(new int[]{100}), is(1));
    }

    @Test
    public void test4() {
        assertThat(hi.hIndex(new int[]{0, 0}), is(0));
    }

    @Test
    public void test5() {
        assertThat(hi.hIndex(new int[]{0, 1}), is(1));
    }

    @Test
    public void test6() {
        assertThat(hi.hIndex(new int[]{1, 0}), is(1));
    }

    @Test
    public void test7() {
        assertThat(hi.hIndex(new int[]{1, 1}), is(1));
    }
}
