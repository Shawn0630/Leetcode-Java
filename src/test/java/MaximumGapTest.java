import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaximumGapTest {

    MaximumGap mg = new MaximumGap();

    @Test
    public void test1() {
        int[] test = new int[]{1};
        mg.radixSort(test);
        assertThat(test, is(new int[]{1}));
    }

    @Test
    public void test2() {
        int[] test = new int[]{};
        mg.radixSort(test);
        assertThat(test, is(new int[]{}));
    }


    @Test
    public void test3() {
        int[] test = new int[]{3, 100, 2, 4};
        mg.radixSort(test);
        assertThat(test, is(new int[]{2, 3, 4, 100}));
    }

}
