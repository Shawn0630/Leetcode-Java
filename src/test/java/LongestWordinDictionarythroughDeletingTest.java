import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LongestWordinDictionarythroughDeletingTest {
    LongestWordinDictionarythroughDeleting lwdtd = new LongestWordinDictionarythroughDeleting();

    @Test
    public void test1() {
        assertThat(lwdtd.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")), is("apple"));
    }
}
