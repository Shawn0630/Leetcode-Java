import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FindFirstandLastPositionofElementSortedArrayTest {
    FindFirstandLastPositionofElementinSortedArray fflp = new FindFirstandLastPositionofElementinSortedArray();

    @Test
    public void test1() {
        assertThat(fflp.searchRange(new int[]{5,7,7,8,8,10}, 8), is(new int[]{3, 4}));
    }

    @Test
    public void test2() {
        assertThat(fflp.searchRange(new int[]{5,7,7,8,8,10}, 6), is(new int[]{-1, -1}));
    }

    @Test
    public void test3() {
        assertThat(fflp.searchRange(new int[]{1}, 1), is(new int[]{0, 0}));
    }

    @Test
    public void test4() {
        assertThat(fflp.searchRange(new int[]{1, 2, 3}, 2), is(new int[]{1, 1}));
    }

    @Test
    public void test5() {
        assertThat(fflp.searchRange(new int[]{1, 2, 3}, 3), is(new int[]{2, 2}));
    }

    @Test
    public void test6() {
        assertThat(fflp.searchRange(new int[]{2, 2}, 2), is(new int[]{0, 1}));
    }
}
