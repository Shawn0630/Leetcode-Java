import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GenerateParenthesisTest {
    GenerateParenthesis gp;

    @Before
    public void before() {
        gp = new GenerateParenthesis();
    }

    @Test
    public void test1() {
        assertEquals(1, gp.generateParenthsis(1).size());
    }

    @Test
    public void test2() {
        assertEquals(5, gp.generateParenthsis(3).size());
    }
}
