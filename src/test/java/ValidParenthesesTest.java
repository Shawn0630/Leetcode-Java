import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ValidParenthesesTest {
    ValidParentheses vp;

    @Before
    public void setUp() throws Exception {
        vp = new ValidParentheses();
    }

    @Test
    public void test1() {
        assertEquals(true, vp.isValid("()"));
    }

    @Test
    public void test2() {
        assertEquals(true, vp.isValid("()[]{}"));
    }

    @Test
    public void test3() {
        assertEquals(false, vp.isValid("(]"));
    }

    @Test
    public void test4() {
        assertEquals(false, vp.isValid("([)]"));
    }

    @Test
    public void test5() {
        assertEquals(true, vp.isValid("{[]}"));
    }

    @Test
    public void test6() {
        assertEquals(false, vp.isValid("]"));
    }
}
