import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FindKCloestElementsTest {

    FindKClosestElements fce = new FindKClosestElements();
    @Test
    public void test1() {
        assertThat(fce.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3), is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void test2() {
        assertThat(fce.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1), is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void test3() {
        assertThat(fce.findClosestElements(new int[]{1, 2, 4, 5}, 2, 3), is(Arrays.asList(2, 4)));
    }

    @Test
    public void test4() {
        assertThat(fce.findClosestElements(new int[]{1, 2}, 1, 1), is(Arrays.asList(1)));
    }

    @Test
    public void test5() {
        assertThat(fce.findClosestElements(new int[]{0, 0, 0, 0, 1, 2, 3}, 3, 0), is(Arrays.asList(0, 0, 0)));
    }

    @Test
    public void test6() {
        assertThat(fce.findClosestElements(new int[]{0, 0, 0, 0, 1, 2, 3}, 3, 3), is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void test7() {
        assertThat(fce.findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8},2 ,2), is(Arrays.asList(1, 3)));
    }

}
