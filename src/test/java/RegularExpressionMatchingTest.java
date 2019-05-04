import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegularExpressionMatchingTest {
    RegularExpressionMatching rem = new RegularExpressionMatching();

    @Test
    public void test1() {
        assertFalse(rem.isMatch("aa", "a"));
    }

    @Test
    public void test2() {
        assertTrue(rem.isMatch("aa", "a*"));
    }

    @Test
    public void test3() {
        assertTrue(rem.isMatch("ab", ".*"));
    }

    @Test
    public void test4() {
        assertTrue(rem.isMatch("aab", "c*a*b"));
    }

    @Test
    public void test5() {
        assertFalse(rem.isMatch("mississippi", "mis*is*p*."));
    }
}
