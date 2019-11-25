import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class AmazonSolution1Test {

    AmazonSolution1 as1 = new AmazonSolution1();

    @Test
    public void test1() {
        assertThat(as1.orderedJunctionBoxes(6, Arrays.asList("ykc 82 01", "eo first qpx", "09z cat hamster", "06f 12 25 6", "az0 first qpx", "236 cat dog rabbit snake")),
                is(Arrays.asList(
                        "236 cat dog rabbit snake",
                        "09z cat hamster",
                        "az0 first qpx",
                        "eo first qpx",
                        "ykc 82 01",
                        "06f 12 25 6"
                )));
    }

    @Test
    public void test2() {
        assertThat(as1.orderedJunctionBoxes(6, Arrays.asList("t2 13 121 98", "r1 box ape bit", "b4 xi me nu", "br8 eat nim did", "w1 has uni gry", "f3 52 54 31")),
                is(Arrays.asList(
                        "r1 box ape bit",
                        "br8 eat nim did",
                        "w1 has uni gry",
                        "b4 xi me nu",
                        "t2 13 121 98",
                        "f3 52 54 31"
                )));
    }
}
