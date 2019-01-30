import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class UnCommonFromSentencesTest {

    UncommonFromSentences ucfs;

    @Before
    public void setup() throws Exception {
        ucfs = new UncommonFromSentences();
    }

    @Test
    public void test1() {
        String[] exp = new String[]{"sweet","sour"};
        String[] act = ucfs.uncommonFromSentences("this apple is sweet", "this apple is sour");
        Arrays.sort(exp);
        Arrays.sort(act);
        assertArrayEquals(exp, act);
    }

    @Test
    public void test2() {
        String[] exp = new String[]{"banana"};
        String[] act = ucfs.uncommonFromSentences("apple apple", "banana");
        Arrays.sort(exp);
        Arrays.sort(act);
        assertArrayEquals(exp, act);
    }
}
