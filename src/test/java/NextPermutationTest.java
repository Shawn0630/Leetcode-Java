import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NextPermutationTest {
    NextPermutation np = new NextPermutation();

    @Test
    public void test1() {
        int[] array1 = new int[]{1, 2, 3};
        np.nextPermutation(array1);
        assertThat(array1, is(new int[]{1, 3, 2}));
        np.nextPermutation(array1);
        assertThat(array1, is(new int[]{2, 1, 3}));
        np.nextPermutation(array1);
        assertThat(array1, is(new int[]{2, 3, 1}));
        np.nextPermutation(array1);
        assertThat(array1, is(new int[]{3, 1, 2}));
        np.nextPermutation(array1);
        assertThat(array1, is(new int[]{3, 2, 1}));
        np.nextPermutation(array1);
        assertThat(array1, is(new int[]{1, 2, 3}));
    }
}
