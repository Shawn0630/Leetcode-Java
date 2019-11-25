import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class NetworkDelayTimeTest {

    NetworkDelayTime ndt = new NetworkDelayTime();

    @Test
    public void test1() {
        assertThat(ndt.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2), is(2));
    }

    @Test
    public void test2() {
        assertThat(ndt.networkDelayTime(new int[][]{{1,2,1},{2,1,3}}, 2, 2), is(3));
    }
}
