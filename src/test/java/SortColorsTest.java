import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SortColorsTest {
    SortColors sc = new SortColors();

    @Test
    public void test1() {
        int[] nums = new int[]{2,0,2,1,1,0};
        sc.sortColors(nums);
        assertThat(nums, is(new int[]{0, 0, 1, 1, 2, 2}));
    }
}
