import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class HuaweiSolutionTest1 {

    @Test
    public void test1() {
        assertThat(HuaweiSolution1.minimalNumberOfPackages(16, 2, 10), is(8));
    }

    @Test
    public void test2() {
        assertThat(HuaweiSolution1.minimalNumberOfPackages(100, 2, 10), is(-1));
        assertThat(HuaweiSolution1.minimalNumberOfPackages(-100, 2, 10), is(-1));
    }

    @Test
    public void test3() {
        assertThat(HuaweiSolution1.minimalNumberOfPackages(11, 15, 6), is(3));
    }


    @Test
    public void test4() {
        assertThat(HuaweiSolution1.minimalNumberOfPackages(0, 2, 5), is(0));
    }


    @Test
    public void test5() {
        List<Integer> result = new ArrayList<>();
        HuaweiSolution1.bin(9, result);
        System.out.print(result);

        HuaweiSolution1.flipShift(7, 15);
    }

    @Test
    public void test6() {
        System.out.print(HuaweiSolution1.nextPower2(16));
    }
}
