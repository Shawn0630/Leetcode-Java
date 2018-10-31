import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromeTest {

    LongestPalindrome lp;

    @Before
    public void setup() throws Exception {
        lp = new LongestPalindrome();
    }

    @Test
    public void test1() {
        assertEquals(7, lp.longestPalindrome("abccccdd"));
    }

}
