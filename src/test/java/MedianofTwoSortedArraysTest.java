import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MedianofTwoSortedArraysTest {

    MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();

    @Test
    public void test1() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), is(2.0));
    }

    @Test
    public void test2() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), is(2.5));
    }

    @Test
    public void test8() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2}), is(2.5));
    }

    @Test
    public void test9() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}), is(2.5));
    }

    @Test
    public void test3() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{}, new int[]{1}), is(1.0));
    }

    @Test
    public void test4() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{}, new int[]{1, 2}), is(1.5));
    }

    @Test
    public void test5() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}), is(-1.0));
    }

    @Test
    public void test6() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{100001}, new int[]{100000}), is(100000.5));
    }

    @Test
    public void test7() {
        assertThat(mtsa.findMedianSortedArrays(new int[]{100000}, new int[]{100001}), is(100000.5));
    }
}
