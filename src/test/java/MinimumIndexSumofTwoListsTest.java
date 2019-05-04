import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class MinimumIndexSumofTwoListsTest {
    MinimumIndexSumofTwoLists mistl = new MinimumIndexSumofTwoLists();

    @Test
    public void test1() {
        assertThat(Arrays.asList(mistl.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})),
                    containsInAnyOrder(Arrays.asList("Shogun")));
    }
}
