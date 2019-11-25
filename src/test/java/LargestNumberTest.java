import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LargestNumberTest {

    LargestNumber ln = new LargestNumber();

    @Test
    public void test1() {
        assertThat(ln.largestNumber(new int[]{10, 2}), is("210"));
    }

    @Test
    public void test2() {
        assertThat(ln.largestNumber(new int[]{3,30,34,5,9}), is("9534330"));
    }

    @Test
    public void test3() {
        assertThat(ln.largestNumber(new int[]{1, 1, 1}), is("111"));
    }

    @Test
    public void test4() {
        assertThat(ln.largestNumber(new int[]{128, 12}), is("12812"));
    }

    @Test
    public void test5() {
        assertThat(ln.largestNumber(new int[]{0, 0}), is("0"));
    }

    @Test
    public void test6() {
        assertThat(ln.largestNumber(new int[]{10, 0}), is("100"));
    }

    @Test
    public void test8() {
        assertThat(ln.largestNumber(new int[]{3, 33}), is("333"));
    }

    @Test
    public void test7() {
        assertThat(ln.largestNumber(new int[]{3,43,48,94,85,33,64,32,63,66}), is("100"));
    }

}
