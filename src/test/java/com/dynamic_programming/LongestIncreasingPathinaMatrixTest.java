package com.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LongestIncreasingPathinaMatrixTest {
    LongestIncreasingPathinaMatrix lipm = new LongestIncreasingPathinaMatrix();

    @Test
    public void test1() {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};

        assertThat(lipm.longestIncreasingPath(nums), is(4));
    }

    @Test
    public void test2() {
        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}};

        assertThat(lipm.longestIncreasingPath(nums), is(4));
    }

    @Test
    public void test3() {
        int[][] nums = {};

        assertThat(lipm.longestIncreasingPath(nums), is(0));
    }
}
