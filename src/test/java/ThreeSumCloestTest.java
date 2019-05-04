import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ThreeSumCloestTest {

    ThreeSumCloest tsc = new ThreeSumCloest();
    @Test
    public void test1() {
        assertThat(tsc.threeSumClosest(new int[] {-1, 2, 1, -4}, 1), is(2));
    }


    @Test
    public void test2() {
        assertThat(tsc.optimaUtilization(7000,
                Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 4000), Arrays.asList(3, 6000)),
                Arrays.asList(Arrays.asList(1, 2000))
                ), is(Arrays.asList(Arrays.asList(2, 1))));
    }

    @Test
    public void test3() {
        assertThat(tsc.optimaUtilization(10000,
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000), Arrays.asList(4, 10000)),
                Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 3000), Arrays.asList(3, 4000), Arrays.asList(4, 5000))
        ), is(Arrays.asList(Arrays.asList(2, 4), Arrays.asList(3, 2))));
    }

}
