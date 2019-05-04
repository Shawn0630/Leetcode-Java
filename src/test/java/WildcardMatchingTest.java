import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WildcardMatchingTest {
    WildcardMatching wm = new WildcardMatching();

    @Test
    public void test1() {
        assertFalse(wm.isMatch("aa", "a"));
    }

    @Test
    public void test2() {
        assertTrue(wm.isMatch("aa", "*"));
    }

    @Test
    public void test3() {
        assertFalse(wm.isMatch("cb", "?a"));
    }

    @Test
    public void test4() {
        assertTrue(wm.isMatch("adceb", "*a*b"));
    }

    @Test
    public void test5() {
        assertFalse(wm.isMatch("acdcb", "a*c?b"));
    }

    @Test
    public void test6() {
        assertFalse(wm.isMatch("aab", "c*a*b"));
    }

    @Test
    public void test7() {
        assertTrue(wm.isMatch("", ""));
        assertTrue(wm.isMatch("", "*"));
        assertTrue(wm.isMatch("ho", "**ho"));
    }
}
