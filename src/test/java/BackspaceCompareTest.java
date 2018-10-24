import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BackspaceCompareTest {

    BackspaceCompare bc;

    @Before
    public void setup() throws Exception {
        bc = new BackspaceCompare();
    }

    @Test
    public void test1() {
        assertTrue(bc.backspaceCompare("ab#c", "ad#c"));
    }

    @Test
    public void test2() {
        assertTrue(bc.backspaceCompare("ab##", "c#d#"));
    }

    @Test
    public void test3() {
        assertTrue(bc.backspaceCompare("a##c", "#a#c"));
    }

    @Test
    public void test4() {
        assertFalse(bc.backspaceCompare("a#c", "b"));
    }

    @Test
    public void test5() {
        assertTrue(bc.backspaceCompare("y#fo##f",  "y#f#o##f"));
    }

}
