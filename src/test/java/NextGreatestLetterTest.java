import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextGreatestLetterTest {

    NextGreatestLetter ngl;
    @Before
    public void setup() throws Exception {
        ngl = new NextGreatestLetter();
    }

    @Test
    public void test1() {
        char[] test1 = {'c', 'f', 'j'};

        assertEquals('c', ngl.nextGreatestLetter(test1, 'a'));
        assertEquals('f', ngl.nextGreatestLetter(test1, 'c'));
        assertEquals('f', ngl.nextGreatestLetter(test1, 'd'));
        assertEquals('j', ngl.nextGreatestLetter(test1, 'g'));
        assertEquals('c', ngl.nextGreatestLetter(test1, 'j'));
        assertEquals('c', ngl.nextGreatestLetter(test1, 'k'));
    }

    @Test
    public void test2() {
        char[] test2 = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};

        assertEquals('n', ngl.nextGreatestLetter(test2, 'e'));
        assertEquals('e', ngl.nextGreatestLetter(test2, 'n'));
    }
}
