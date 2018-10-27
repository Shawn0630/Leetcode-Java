import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.assertEquals;

public class FindPairsTest {

    FindPairs fp;

    @Before
    public void setup() throws Exception {
        fp = new FindPairs();
    }

    @Test
    public void test1() {
        assertEquals(2, fp.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

    @Test
    public void test2() {
        assertEquals(4, fp.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void test3() {
        assertEquals(1, fp.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    @Test
    public void test4() {
        assertEquals(1, fp.findPairs(new int[]{1, 1, 1, 1, 1}, 0));
    }

    @Test
    public void test5() {
        assertEquals(2, fp.findPairs(new int[]{6, 7, 3, 6, 4, 6, 3, 5, 6, 9}, 4));
    }

    @Test
    public void test6() {
        assertEquals(0, fp.findPairs(new int[]{1, 2, 3, 4, 5}, -1));
    }
}
