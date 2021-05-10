package com.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MinimumPathSumTest {

    MinimumPathSum mps = new MinimumPathSum();

    @Test
    public void test1() {
        assertThat(mps.minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}), is(7));
    }
}
