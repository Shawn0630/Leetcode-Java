import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TopKElementinFrameTest {


    TopKElementinFrame tef = new TopKElementinFrame();

    @Test
    public void test1() {
        assertThat(tef.topK(new int[]{5, 2, 1, 3, 2}, 4), is(Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(2, 5),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 2, 3, 5),
                Arrays.asList(2, 1, 3, 5)
        )));
    }
}
