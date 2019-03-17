import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BracesTest {

    @Test
    public void test1(){
        assertTrue(Braces.isValid("{}[]()"));
        assertFalse(Braces.isValid("{[}]}"));
    }

    @Test
    public void test2() {
        Braces.braces(new String[]{});
    }
}
