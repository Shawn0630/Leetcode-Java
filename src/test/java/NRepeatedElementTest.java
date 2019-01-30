import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NRepeatedElementTest {
    NRepeatedElement nre;


    @Before
    public void setup() throws Exception {
        nre = new NRepeatedElement();
    }

    @Test
    public void test1() {
        assertEquals(3, nre.repeatedNTimes(new int[]{1,2,3,3}));
    }

    @Test
    public void test2() {
        assertEquals(2, nre.repeatedNTimes(new int[]{2,1,2,5,3,2}));
    }

    @Test
    public void test3() {
        assertEquals(5, nre.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }
}
