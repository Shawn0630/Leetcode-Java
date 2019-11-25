import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class SearchRotatedSortedArrayTest {

    SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();

    @Test
    public void test1() {
        Assert.assertThat(srsa.search(new int[]{4,5,6,7,0,1,2}, 0), is(4));
        Assert.assertThat(srsa.search(new int[]{4,5,6,7,0,1,2}, 3), is(-1));
    }

    @Test
    public void test2() {
        Assert.assertThat(srsa.search(new int[]{1, 3}, 3), is(1));
    }

    @Test
    public void test3() {
        Assert.assertThat(srsa.search(new int[]{5, 1, 3}, 3), is(2));
    }

    @Test
    public void test4() {
        Assert.assertThat(srsa.search(new int[]{3, 5, 1}, 3), is(0));
    }

    @Test
    public void test5() {
        Assert.assertThat(srsa.search(new int[]{3, 1}, 1), is(1));
    }

    @Test
    public void test6() {
        Assert.assertThat(srsa.search(new int[]{5, 1, 3}, 5), is(0));
    }
}
