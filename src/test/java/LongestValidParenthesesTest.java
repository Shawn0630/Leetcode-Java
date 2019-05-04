import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestValidParenthesesTest {

    LongestValidParentheses lvp = new LongestValidParentheses();

    @Test
    public void test1() {
        assertThat(lvp.longestValidParentheses("(()"), is(2));
    }

    @Test
    public void test2() {
        assertThat(lvp.longestValidParentheses(")()())"), is(4));
    }
}
