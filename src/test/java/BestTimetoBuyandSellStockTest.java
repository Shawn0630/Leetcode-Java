import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BestTimetoBuyandSellStockTest {

    BestTimetoBuyandSellStock st = new BestTimetoBuyandSellStock();
    @Test
    public void test1() {
        assertThat(st.maxProfit2(new int[]{7,1,5,3,6,4}), is(7));
        assertThat(st.maxProfit(new int[]{7,1,5,3,6,4}), is(5));
    }

    @Test
    public void test2() {
        assertThat(st.maxProfit2(new int[]{7,6,4,3,1}), is(0));
        assertThat(st.maxProfit3(2, new int[]{7,6,4,3,1}), is(0));
    }

    @Test
    public void test3() {
        assertThat(st.maxProfit2(new int[]{1, 2, 3, 4, 5}), is(4));
    }

    @Test
    public void test4() {
        assertThat(st.maxProfit3(2, new int[]{3,3,5,0,0,3,1,4}), is(6));
    }

    @Test
    public void test5() {
        assertThat(st.maxProfit3(2, new int[]{1,2,3,4,5}), is(4));
    }

    @Test
    public void test6() {
        assertThat(st.maxProfit3(2, new int[]{2, 4, 1}), is(2));
    }

    @Test
    public void test7() {
        assertThat(st.maxProfit3(2, new int[]{1, 2, 4}), is(3));
    }

    @Test
    public void test8() {
        assertThat(st.maxProfit3(2, new int[]{3, 2, 6, 5, 0, 3}), is(7));
    }

    @Test
    public void test9() {
        assertThat(st.maxProfit4(new int[]{1, 2, 3, 0, 2}), is(3));
    }

    @Test
    public void test10() {
        assertThat(st.maxProfit4(new int[]{6,1,3,2,4,7}), is(6));
    }


}
