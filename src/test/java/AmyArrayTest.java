import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class AmyArrayTest {


    @Test
    public void test1() {
        assertEquals(Arrays.asList(2, 3), AmyArray.counts(Arrays.asList(1, 2, 3), Arrays.asList(2, 4)));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList(2, 3, 3, 3), AmyArray.counts(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 3, 3)));
    }
}
