import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReorderLogFilesTest {

    ReorderLogFiles rlf = new ReorderLogFiles();
    @Test
    public void test1() {
        assertThat(rlf.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"}), is(new String[]{"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"}));
    }

    @Test
    public void test2() {
        assertThat(rlf.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"}), is(new String[]{"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"}));
    }
}
