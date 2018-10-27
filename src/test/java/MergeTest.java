import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeTest {

    Merge m;
    @Before
    public void setup() throws Exception {
        m = new Merge();
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, m.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2 ,5, 6}, 3));
    }

}
