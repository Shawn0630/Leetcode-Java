import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TwoSumsTest {

    TwoSums ts;

    @Before
    public void before() {
        ts = new TwoSums();
    }

    @Test
    public void test1() {
        assertEquals(3, ts.twoSums(new int[]{-2, -1, 3, -3, 1, 1, 0, 2, 15}).size());
    }
}
