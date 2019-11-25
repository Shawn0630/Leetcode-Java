import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AjacentStatesTest {

    AjacentStates as = new AjacentStates();
    @Test
    public void test1() {
        assertThat(as.cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1), is(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0)));
    }

    @Test
    public void test2() {
        assertThat(as.cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2), is(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0)));
    }
}
