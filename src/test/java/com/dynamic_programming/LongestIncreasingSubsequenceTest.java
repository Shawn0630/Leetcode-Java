package com.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestIncreasingSubsequenceTest {

    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

    @Test
    public void test1() {
        assertThat(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}), is(4));
    }
}
