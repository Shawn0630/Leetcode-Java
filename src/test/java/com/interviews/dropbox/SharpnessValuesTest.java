package com.interviews.dropbox;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SharpnessValuesTest {

    SharpnessValues sharpnessValues = new SharpnessValues();

    @Test
    public void test1() {
        int[][] grid = new int[][] {
                {5, 7, 2},
                {7, 5, 8},
                {9, 1, 5}
        };
        assertEquals(7, sharpnessValues.sharpnessValue(grid));
        assertEquals(7, sharpnessValues.sharpnessValueDP(grid));
        assertEquals(7, sharpnessValues.sharpnessValueDPSpaceOptimised(grid));
        assertEquals(7, sharpnessValues.sharpnessValueDivideConquer(grid));
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] {
                {1, 2, 3}
        };

        assertEquals(1, sharpnessValues.sharpnessValue(grid));
        assertEquals(1, sharpnessValues.sharpnessValueDP(grid));
        assertEquals(1, sharpnessValues.sharpnessValueDPSpaceOptimised(grid));
        assertEquals(1, sharpnessValues.sharpnessValueDivideConquer(grid));
    }

    @Test
    public void test3() {
        int[][] grid = new int[][] {
                {3}
        };

        assertEquals(3, sharpnessValues.sharpnessValue(grid));
        assertEquals(3, sharpnessValues.sharpnessValueDP(grid));
        assertEquals(3, sharpnessValues.sharpnessValueDPSpaceOptimised(grid));
        assertEquals(3, sharpnessValues.sharpnessValueDivideConquer(grid));
    }
}
