import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CombinationSumTest {
    CombinationSum cs = new CombinationSum();

    @Test
    public void test1() {
        assertThat(cs.combinationSum(new int[]{2,3,6,7}, 7), containsInAnyOrder(
                Arrays.asList(7),
                Arrays.asList(2, 2, 3))
        );
    }

    @Test
    public void test2() {
        assertThat(cs.combinationSum(new int[]{2,3,5}, 8), containsInAnyOrder(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5))
        );
    }

    @Test
    public void test3() {
        assertThat(cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8), containsInAnyOrder(
                Arrays.asList(1, 7),
                Arrays.asList(1, 2, 5),
                Arrays.asList(2, 6),
                Arrays.asList(1, 1, 6)
        ));
    }

    @Test
    public void test4() {
        assertThat(cs.combinationSum2(new int[]{2,5,2,1,2}, 5), containsInAnyOrder(
                Arrays.asList(1, 2, 2),
                Arrays.asList(5)
        ));
    }

    @Test
    public void test5() {
        assertThat(cs.combinationSum3(3, 7), containsInAnyOrder(
                Arrays.asList(1, 2, 4)
        ));
    }

    @Test
    public void test6() {
        assertThat(cs.combinationSum3(3, 9), containsInAnyOrder(
                Arrays.asList(1, 2, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 3, 4)
        ));
    }

    @Test
    public void test7() {
        assertThat(cs.combinationSum3(3, 15), containsInAnyOrder(
                Arrays.asList()
        ));
    }

    @Test
    public void test8() {
        assertThat(cs.combinationSum4(new int[]{1, 2, 3}, 4), is(7));
    }

    @Test
    public void test9() {
        System.out.println(cs.combinationSum4(new int[]{2, 1, 3}, 35));
    }

    @Test
    public void test10() {
        assertThat(cs.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10),
                is(9));
    }
}
