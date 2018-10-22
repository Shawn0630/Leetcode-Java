import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {
    LongestCommonPrefix lcp;

    @Before
    public void setUp() throws Exception {
        lcp = new LongestCommonPrefix();
    }

    @Test
    public void test1() {
        assertEquals("fl", lcp.longestCommonPrefix("flower", "flight"));
        assertEquals("fl", lcp.longestCommonPrefix("flower", "fli"));
        assertEquals("fl", lcp.longestCommonPrefix("flight", "flower"));
        assertEquals("fl", lcp.longestCommonPrefix("fli", "flower"));
        assertEquals("", lcp.longestCommonPrefix("abc", "d"));
        assertEquals("", lcp.longestCommonPrefix("", ""));

    }
}
