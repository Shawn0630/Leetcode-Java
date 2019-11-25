import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class AmazonPrimeAirTest {

    AmazonPrimeAir apa = new AmazonPrimeAir();

    @Test
    public void test1() {
        List<List<Integer>> forwardList = Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 4000), Arrays.asList(3, 6000));
        List<List<Integer>> returnList = Arrays.asList(Arrays.asList(1, 2000));
        //System.out.print(apa.solution(7000, forwardList, returnList));
        assertThat(apa.solution(7000, forwardList, returnList), containsInAnyOrder(Arrays.asList(2, 1)));
    }


    @Test
    public void test2() {
        List<List<Integer>> forwardList = Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000), Arrays.asList(4, 10000));
        List<List<Integer>> returnList = Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 3000), Arrays.asList(3, 4000), Arrays.asList(4, 5000));
        //System.out.print(apa.solution(10000, forwardList, returnList));
        assertThat(apa.solution(10000, forwardList, returnList), containsInAnyOrder(Arrays.asList(2, 4), Arrays.asList(3, 2)));
    }

    @Test
    public void test3() {
        List<List<Integer>> forwardList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3));
        List<List<Integer>> returnList = Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 2));
        //System.out.print(apa.solution(10000, forwardList, returnList));
        assertThat(apa.solution(4, forwardList, returnList), containsInAnyOrder(Arrays.asList(1, 2), Arrays.asList(2, 1)));
    }

    @Test
    public void test4() {
        List<List<Integer>> forwardList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 1000), Arrays.asList(4, 2000), Arrays.asList(5, 3000));
        List<List<Integer>> returnList = Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 2));
        //System.out.print(apa.solution(10000, forwardList, returnList));
        assertThat(apa.solution(4, forwardList, returnList), containsInAnyOrder(Arrays.asList(1, 2), Arrays.asList(2, 1)));
    }
}
