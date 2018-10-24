import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseVowelsTest {

    ReverseVowels rv;

    @Before
    public void setup() throws Exception {
        rv = new ReverseVowels();
    }

    @Test
    public void test1() {
        assertEquals("holle", rv.reverseVowels("hello"));
        assertEquals("leotcede", rv.reverseVowels("leetcode"));
        assertEquals("EO", rv.reverseVowels("OE"));
        assertEquals(",.", rv.reverseVowels(",."));
    }
}
