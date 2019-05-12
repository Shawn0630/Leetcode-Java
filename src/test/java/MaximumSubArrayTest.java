import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaximumSubArrayTest {
    MaximumSubarray msa = new MaximumSubarray();

    @Test
    public void test1() {
        assertThat(msa.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), is(6));
    }
}
