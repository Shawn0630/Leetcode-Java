import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InsertIntervalTest {

    InsertInterval ii = new InsertInterval();


    @Test
    public void test0() {
        assertThat(ii.pos(new int[][]{{1, 4}}, new int[]{0, 3}), is(0));
        assertThat(ii.secPos(new int[][]{{1, 4}}, new int[]{0, 3}), is(0));
    }

    @Test
    public void test1() {
        assertThat(ii.pos(new int[][]{{1, 4}}, new int[]{1, 3}), is(0));
        assertThat(ii.secPos(new int[][]{{1, 4}}, new int[]{1, 3}), is(0));
    }

    @Test
    public void test2() {
        assertThat(ii.pos(new int[][]{{1, 4}, {6, 9}}, new int[]{5, 10}), is(1));
        assertThat(ii.secPos(new int[][]{{1, 4}, {6, 9}}, new int[]{5, 10}), is(2));
    }

    @Test
    public void test3() {
        assertThat(ii.pos(new int[][]{{1, 4}, {6, 9}, {10, 15}}, new int[]{5, 10}), is(1));
        assertThat(ii.secPos(new int[][]{{1, 4}, {6, 9}, {10, 15}}, new int[]{5, 10}), is(2));
    }

    @Test
    public void test4() {
        assertThat(ii.pos(new int[][]{{1, 4}, {6, 9}, {10, 15}}, new int[]{20, 30}), is(3));
        assertThat(ii.secPos(new int[][]{{1, 4}, {6, 9}, {10, 15}}, new int[]{20, 30}), is(3));
    }

    @Test
    public void test5() {
        assertThat(ii.pos(new int[][]{{1, 4}, {6, 9}, {20, 30}}, new int[]{15, 16}), is(2));
        assertThat(Arrays.copyOfRange(new int[][]{{1, 4}, {6, 9}, {20, 30}}, 0, 2), is(new int[][]{{1, 4}, {6, 9}}));
        assertThat(Arrays.copyOfRange(new int[][]{{1, 4}, {6, 9}, {20, 30}}, 2, 3), is(new int[][]{{20, 30}}));
        assertThat(Arrays.copyOfRange(new int[][]{{1, 4}, {6, 9}, {20, 30}}, 3, 3), is(new int[][]{}));
        assertThat(ii.secPos(new int[][]{{1, 4}, {6, 9}, {20, 30}}, new int[]{15, 16}), is(2));
    }

    @Test
    public void test6() {
        assertThat(ii.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}), is(new int[][]{{1, 5}, {6, 9}}));
    }

    @Test
    public void test7() {
        assertThat(ii.secPos(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8}), is(3));
        assertThat(ii.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8}), is(new int[][]{{1, 2}, {3, 10}, {12, 16}}));
    }

    @Test
    public void test8() {
        assertThat(ii.insert(new int[][]{}, new int[]{5, 7}), is(new int[][]{{5, 7}}));
    }

    @Test
    public void test9() {
        assertThat(ii.insert(new int[][]{{1, 5}}, new int[]{2, 7}), is(new int[][]{{1, 7}}));
        assertThat(Arrays.copyOfRange(new int[][]{{1, 5}}, 1, 1), is(new int[][]{}));
    }

    @Test
    public void test10() {
        assertThat(ii.insert(new int[][]{{1, 5}}, new int[]{6, 8}), is(new int[][]{{1, 5}, {6, 8}}));
    }

    @Test
    public void test11() {
        assertThat(ii.insert(new int[][]{{1, 5}}, new int[]{2, 3}), is(new int[][]{{1, 5}}));
    }

}
