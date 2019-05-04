import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    BinarySearch bs = new BinarySearch();

    @Test
    public void test1() {
        assertThat(bs.search(new int[]{-1,0,3,5,9,12}, 9), is(4));
    }

    @Test
    public void test2() {
        assertThat(bs.search(new int[]{-1,0,3,5,9,12}, 2), is(-1));
    }
}
