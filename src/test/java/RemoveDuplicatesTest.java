import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {
    RemoveDuplicates rd;

    @Before
    public void setup() throws Exception {
        rd = new RemoveDuplicates();
    }

    @Test
    public void test1() {
        assertEquals(5, rd.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    @Test
    public void test2() {
        assertEquals(7, rd.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    @Test
    public void test3() {
        assertEquals(2, rd.removeDuplicates(new int[]{1, 1}));
    }

    @Test
    public void test4() {
        assertEquals(0, rd.removeDuplicates(new int[]{}));
    }

    @Test
    public void test5() {
        assertEquals(1, rd.removeDuplicates(new int[]{1}));
    }

    @Test
    public void test6() {
        assertEquals(2, rd.removeDuplicates(new int[]{1, 2}));
    }

}
