import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RemoveAllAdjacentDupliatesInStringTest {
    RemoveAllAdjacentDuplicatesInString rad = new RemoveAllAdjacentDuplicatesInString();

    @Test
    public void test1() {
        assertThat(rad.removeDuplicates("abbaca"), is("ca"));
    }

    @Test
    public void test2() {
        assertThat(rad.removeDuplicates("a"), is("a"));
    }


}
