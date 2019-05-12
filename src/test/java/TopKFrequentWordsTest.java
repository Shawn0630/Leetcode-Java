import org.junit.Test;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class TopKFrequentWordsTest {
    TopKFrequentWords tkf = new TopKFrequentWords();

    @Test
    public void test1() {
        assertThat(tkf.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2), is(Arrays.asList("i", "love")));
    }
}
