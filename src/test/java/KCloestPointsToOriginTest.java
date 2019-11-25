import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class KCloestPointsToOriginTest {

    KClosestPointstoOrigin kc = new KClosestPointstoOrigin();

    @Test
    public void test1() {
        assertThat(kc.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1), is(new int[][]{{-2, 2}}));
    }

    @Test
    public void test2() {
        assertThat(kc.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2), is(new int[][]{{3, 3}, {-2, 4}}));
    }


    @Test
    public void testQuickSort() {
        Integer[] array = new Integer[]{3, 2, 2, 1, 4, 6, 4};

        BiFunction<Integer, Integer, Boolean> comparator = (o1, o2) -> o1 <= o2;
        kc.quickSort(array, comparator, 0, array.length - 1);
        assertThat(array, is(new Integer[]{1, 2, 2, 3, 4, 4, 6}));
    }
}
