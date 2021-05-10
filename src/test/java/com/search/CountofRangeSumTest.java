package com.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountofRangeSumTest {
    CountofRangeSum crs = new CountofRangeSum();

    @Test
    public void test1() {
        assertThat(crs.countRangeSum(new int[]{0,-3,-3,1,1,2}, 3, 5), is(2));
    }
}
