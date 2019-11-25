import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CoinChangeTest {
    CoinChange cc = new CoinChange();
    @Test
    public void test1() {
        assertThat(cc.coinChange(new int[]{1, 2, 5}, 11), is(3));
    }

    @Test
    public void test2() {
        assertThat(cc.coinChange(new int[]{2}, 3), is(-1));
    }

    @Test
    public void test3() {
        assertThat(cc.coinChange(new int[]{288,160,10,249,40,77,314,429}, 9208), is(22));
    }

    @Test
    public void test4() {
        assertThat(cc.change(5, new int[]{1, 2, 5}), is(4));
    }

    @Test
    public void test5() {
        assertThat(cc.change(3, new int[]{2}), is(0));
    }

    @Test
    public void test6() {
        assertThat(cc.change(10, new int[]{10}), is(1));
    }
}
