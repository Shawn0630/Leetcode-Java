import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeakIndexInMountainArrayTest {

    PeakIndexInMountainArray pima;

    @Before
    public void setup() throws Exception {
        pima = new PeakIndexInMountainArray();
    }

    @Test
    public void test1() {
        int[] test1 = {0, 1, 0};
        assertEquals(1, pima.peakIndexInMountainArray(test1));
    }

    @Test
    public void test2() {
        int[] test2 = {0, 2, 1, 0};
        assertEquals(1, pima.peakIndexInMountainArray(test2));
    }

    @Test
    public void test3() {
        int[] test3 = {3, 4, 5, 1};
        assertEquals(2, pima.peakIndexInMountainArray(test3));
    }



}
