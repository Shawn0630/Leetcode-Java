package utils.ds.sg;

import org.junit.Test;
import utils.ds.st.NumArray;

public class NumArrayTests {
    @Test
    public void test1() {
        NumArray numArray = new NumArray(new int[]{0,9,5,7,3});
        numArray.sumRange(4, 4);
        numArray.sumRange(2, 4);
        numArray.sumRange(3, 3);
        numArray.update(4, 5);
        numArray.update(1, 7);
        numArray.update(0, 8);
        numArray.sumRange(1, 2);
        numArray.update(1, 9);
        numArray.sumRange(4, 4);
        numArray.update(3, 4);
    }
}
