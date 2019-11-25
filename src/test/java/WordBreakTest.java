import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class WordBreakTest {
    WordBreak wb = new WordBreak();

    @Test
    public void test1() {
        assertTrue(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    @Test
    public void test2() {
        assertTrue(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    @Test
    public void test3() {
        assertFalse(wb.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void test4() {
        assertThat(wb.wordBreak2("catsandog", Arrays.asList("cat", "cats", "and", "sand", "dog")), containsInAnyOrder(
                Arrays.asList(
                "cats and dog",
                "cat sand dog"
                )));
    }

    @Test
    public void test5() {
        assertThat(wb.wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")), containsInAnyOrder(
                Collections.emptyList()));
    }


}
