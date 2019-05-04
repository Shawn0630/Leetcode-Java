import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindMinTest {
    FindMin fm = new FindMin();

    @Test
    public void test1() {
        assertThat(fm.findMin(new int[]{3,4,5,1,2}), is(1));
    }

    @Test
    public void test2() {
        assertThat(fm.findMin(new int[]{4,5,6,7,0,1,2}), is(0));
    }

    @Test
    public void test3() {
        assertThat(fm.findMin(new int[]{0, 1, 2, 3, 4, 5}), is(0));
    }

    @Test
    public void test4() {
        assertThat(fm.findMin(new int[]{0}), is(0));
    }

    @Test
    public void test5() {
        assertThat(fm.findMin(new int[]{2, 1}), is(1));
    }

    @Test
    public void test6() {
        assertThat(fm.findMin(new int[]{2, 3, 1}), is(1));
    }

    @Test
    public void test7() {
        assertThat(fm.findMin2(new int[]{2, 2, 2, 0, 1}), is(0));
    }

    @Test
    public void test8() {
        assertThat(fm.findMin2(new int[]{3, 3, 1, 3}), is(1));
    }
}
