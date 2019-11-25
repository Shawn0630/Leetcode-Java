import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MedianFinderTest {

    MedianFinder mf;
    @Before
    public void before() {
        mf = new MedianFinder();
    }

    @Test
    public void test1() {
        mf.addNum(1);
        mf.addNum(2);
        assertThat(mf.findMedian(), is(1.5));
        mf.addNum(3);
        assertThat(mf.findMedian(), is(2.0));
    }
}
