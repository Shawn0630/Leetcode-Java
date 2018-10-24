import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MySqrtTest {

    MySqrt sqrt;
    @Before
    public void setup() throws Exception {
        sqrt = new MySqrt();
    }

    @Test
    public void test1() {
        assertEquals(2, sqrt.mySqrt(4));
        assertEquals(2, sqrt.mySqrt(8));
        assertEquals(1, sqrt.mySqrt(1));
        assertEquals(0, sqrt.mySqrt(0));
        assertEquals(1, sqrt.mySqrt(2));
        assertEquals(46339, sqrt.mySqrt(2147395599));
        assertEquals(46340, sqrt.mySqrt(2147483647));
    }
}
