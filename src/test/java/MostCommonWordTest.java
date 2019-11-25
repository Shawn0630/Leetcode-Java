import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MostCommonWordTest {

    MostCommonWord mcw = new MostCommonWord();
    @Test
    public void test1() {
       for(String s : mcw.words("Bob! hit? a!b a ball, the hit BALL flew far after it was hit.   ")) {
           System.out.println(s);
       }
    }

    @Test
    public void test2() {
        assertThat(mcw.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}), is("ball"));

    }

    @Test
    public void test3() {
        assertThat(mcw.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}), is("b"));
    }

}
