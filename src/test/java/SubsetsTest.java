import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class SubsetsTest {

    Subsets ss = new Subsets();

    @Test
    public void test1() {
        assertThat(ss.subsets(new int[]{1, 2, 3}), containsInAnyOrder(
                Collections.singletonList(3),
                Collections.singletonList(1),
                Collections.singletonList(2),
                Arrays.asList(1,2,3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Collections.emptyList()));
    }

    @Test
    public void test2() {
        assertThat(ss.subsetsWithDup(new int[]{1,2,2}), containsInAnyOrder(
                Arrays.asList(2),
                Arrays.asList(1),
                Arrays.asList(1,2,2),
                Arrays.asList(2, 2),
                Arrays.asList(1, 2),
                Collections.emptyList()));
    }
}
