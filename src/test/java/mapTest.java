import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class mapTest {

    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put(new String("a"), 1);
        map.put(new String("a"), 2);
        map.put(new String("b"), 1);

        assertEquals(map.size(), 2);
        assertFalse(map.entrySet().contains("a"));
        assertTrue(map.containsKey("a"));

    }

    @Test
    public void test2() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(1, 1);

        assertEquals(map.size(), 2);
        assertFalse(map.entrySet().contains(1));
        assertTrue(map.containsKey(1));

    }
}
