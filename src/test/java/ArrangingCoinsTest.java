import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrangingCoinsTest {
    ArrangingCoins ac;

    @Before
    public void setup() throws Exception {
        ac = new ArrangingCoins();
    }

    @Test
    public void test1() {
        assertEquals(2, ac.arrangeCoins(5));
    }

    @Test
    public void test2() {
        assertEquals(3, ac.arrangeCoins(8));
    }
}
