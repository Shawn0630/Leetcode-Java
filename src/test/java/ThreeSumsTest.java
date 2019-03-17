import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ThreeSumsTest {

    ThreeSums ts;

    @Before
    public void before() {
        ts = new ThreeSums();
    }

    @Test
    public void test1() {
        assertEquals(2, ts.threeSums(new int[]{-1, 1, 0, 2, -2}).size());
    }

}
