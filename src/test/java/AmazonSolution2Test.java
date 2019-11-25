import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class AmazonSolution2Test {

    AmazonSolution2 as2 = new AmazonSolution2();

    @Test
    public void test1() {
        assertThat(as2.removeObstacle(3, 3, Arrays.asList(
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 9, 1)
        )), is(3));
    }

    @Test
    public void test2() {
        assertThat(as2.removeObstacle(5, 4, Arrays.asList(
                Arrays.asList(1, 1, 1, 1),
                Arrays.asList(0, 1, 1, 1),
                Arrays.asList(0, 1, 0, 1),
                Arrays.asList(1, 1, 9, 1),
                Arrays.asList(0, 0, 1, 1)
        )), is(5));
    }
}
