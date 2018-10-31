import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestTest {

    KthLargest kl;

    @Before
    public void setup() throws Exception {

    }

    @Test
    public void test1() {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        kl = new KthLargest(3, arr);
        assertEquals(4, kl.add(3));   // returns 4
        assertEquals(5, kl.add(5));   // returns 5
        assertEquals(5, kl.add(10));  // returns 5
        assertEquals(8, kl.add(9));   // returns 8
        assertEquals(8, kl.add(4));   // returns 8
    }
}
