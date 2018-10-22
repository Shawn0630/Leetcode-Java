import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionTest {
    Intersection intersection;

    @Before
    public void setup() throws Exception {
        intersection = new Intersection();
    }

    @Test
    public void test1() {
        int[] array1 = {4, 9, 5};
        int[] array2 = {9, 4, 9, 8, 4};
        int[] expected = {9, 4};
        int[] result = intersection.intersect(array1, array2);

        Arrays.sort(result);
        Arrays.sort(expected);

        assertArrayEquals(expected, result);
    }
}
