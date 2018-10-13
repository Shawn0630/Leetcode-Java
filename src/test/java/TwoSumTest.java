import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    TwoSum ts;

    @Before
    public void setUp() throws Exception {
       ts = new TwoSum();
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[]{1, 2}, ts.twoSum(new int[]{3,2,4}, 6));
    }
}
