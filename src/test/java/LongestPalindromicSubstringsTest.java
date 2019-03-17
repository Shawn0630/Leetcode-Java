import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LongestPalindromicSubstringsTest {

    LongestPalindromicSubstrings lps;

    @Before
    public void before() {
        lps = new LongestPalindromicSubstrings();
    }

    @Test
    public void test1() {
        assertEquals("bab", lps.longestPalidromic("babcd"));
    }

    @Test
    public void test2() {
        assertEquals("bb", lps.longestPalidromic("cbbe"));
    }
}
