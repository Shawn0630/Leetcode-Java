import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RemoveDuplicateLettersTest {

    RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
    @Test
    public void test1() {
        assertThat(rdl.removeDuplicateLetters("bcabc"), is("abc"));
    }
}
