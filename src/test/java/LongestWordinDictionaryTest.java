import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LongestWordinDictionaryTest {
    LongestWordinDictionary lwd = new LongestWordinDictionary();

    @Test
    public void test1() {
        assertThat(lwd.longestWord(new String[]{"w","wo","wor","worl", "world"}), is("world"));
    }

    @Test
    public void test2() {
        assertThat(lwd.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}), is("apple"));
    }

    @Test
    public void test3() {
        assertThat(lwd.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}), is("yodn"));
    }
}
