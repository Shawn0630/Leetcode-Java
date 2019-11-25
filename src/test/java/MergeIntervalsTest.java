import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MergeIntervalsTest {

    MergeIntervals mi = new MergeIntervals();

    @Test
    public void test1() {
        assertThat(mi.merge(new int[][]{{1,3}, {2,6},{8,10},{15,18}}), is(new int[][]{{1,6},{8,10},{15,18}}));
    }

    @Test
    public void test2() {
        assertThat(mi.merge(new int[][]{{1,4},{4,5}}), is(new int[][]{{1, 5}}));
    }

    @Test
    public void test3() {
        assertThat(mi.merge(new int[][]{}), is(new int[][]{}));
    }

    @Test
    public void test4() {
        assertThat(mi.merge(new int[][]{{1,4},{2,3}}), is(new int[][]{{1, 4}}));
    }
}
