import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidPerfectSquareTest {

    ValidPerfectSquare vps;
    @Before
    public void setup() throws Exception {
        vps = new ValidPerfectSquare();
    }

    @Test
    public void test1() {
        assertEquals(false, vps.isPerfectSquare(0));
        assertEquals(true, vps.isPerfectSquare(1));
        assertEquals(true, vps.isPerfectSquare(4));
        assertEquals(true, vps.isPerfectSquare(100));
        assertEquals(false, vps.isPerfectSquare(98));
        assertEquals(true, vps.isPerfectSquare(808201));
    }
}
