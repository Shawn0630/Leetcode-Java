import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {
    SearchInsertPosition sip;

    @Before
    public void setup() throws Exception {
        sip = new SearchInsertPosition();
    }

    @Test
    public void test1() {
        int[] test1 = {1, 3, 5, 6};
        assertEquals(2, sip.searchInsert(test1, 5));
        assertEquals(1, sip.searchInsert(test1, 2));
        assertEquals(4, sip.searchInsert(test1, 7));
        assertEquals(0, sip.searchInsert(test1, 0));
    }

    @Test
    public void test2() {
        int[] test2 = {1};
        assertEquals(0, sip.searchInsert(test2, 1));
        assertEquals(1, sip.searchInsert(test2, 2));
    }

}
