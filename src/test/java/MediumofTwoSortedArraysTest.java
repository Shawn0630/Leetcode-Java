import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MediumofTwoSortedArraysTest {

    MediumofTwoSortedArrays mtsa;

    @Before
    public void before() {
        mtsa = new MediumofTwoSortedArrays();
    }

    @Test
    public void test1() {
        assertEquals(2.0 ,mtsa.findMediumSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    public void test2() {
        assertEquals(2.0, mtsa.findMediumSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    public void test3() {
        assertEquals(1.0, mtsa.findMediumSortedArrays(new int[]{1}, new int[]{1}));
    }
}
