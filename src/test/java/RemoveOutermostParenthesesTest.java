import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RemoveOutermostParenthesesTest {
    RemoveOutermostParentheses rop = new RemoveOutermostParentheses();

    @Test
    public void test1() {
        assertThat(rop.removeOuterParentheses("(()())(())"), is("()()()"));
    }

    @Test
    public void test2() {
        assertThat(rop.removeOuterParentheses("(()())(())(()(()))"), is("()()()()(())"));
    }

    @Test
    public void test3() {
        assertThat(rop.removeOuterParentheses("()()"), is(""));
    }
}
