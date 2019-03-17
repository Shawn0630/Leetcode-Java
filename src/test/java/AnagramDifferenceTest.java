import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnagramDifferenceTest {

    @Test
    public void test1() {
        assertEquals(Integer.valueOf(-1), AnagramDifference.getDifference("a", "bb"));
        assertEquals(Integer.valueOf(0), AnagramDifference.getDifference("jk", "kj"));
        assertEquals(Integer.valueOf(1), AnagramDifference.getDifference("abb", "bbc"));
        assertEquals(Integer.valueOf(2), AnagramDifference.getDifference("mn", "op"));
        assertEquals(Integer.valueOf(3), AnagramDifference.getDifference("abc", "def"));
    }
}
