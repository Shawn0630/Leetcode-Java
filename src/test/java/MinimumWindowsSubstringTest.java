import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MinimumWindowsSubstringTest {
    MinimumWindowSubstring mws = new MinimumWindowSubstring();

    @Test
    public void test1() {
        assertThat(mws.minWindow("ADOBECODEBANC", "ABC"), is("BANC"));
    }

    @Test
    public void test2() {
        assertThat(mws.minWindow("a", "a"), is("a"));
    }

    @Test
    public void test3() {
        assertThat(mws.minWindow("bba", "ba"), is("ba"));
    }

    @Test
    public void test4() {
        assertThat(mws.minWindow("aa", "aa"), is("aa"));
    }

    @Test
    public void test5() {
        assertThat(mws.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"), is("abbbbbcdd"));
    }

}
