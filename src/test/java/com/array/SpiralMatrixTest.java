package com.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SpiralMatrixTest {

    SpiralMatrix sm = new SpiralMatrix();

    @Test
    public void test1() {
        assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5), sm.spiralOrder(new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }}));

    }


    @Test
    public void test2() {
        assertEquals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7), sm.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}}));
    }

    @Test
    public void test3() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), sm.spiralOrder(new int[][]{{1, 2, 3, 4, 5}}));
    }

    @Test
    public void test4() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), sm.spiralOrder(new int[][]{{1}, {2}, {3}, {4}, {5}}));
    }

    @Test
    public void test5() {
        assertEquals(Arrays.asList(2, 5, 8, -1, 0, 4), sm.spiralOrder(new int[][]{{2, 5, 8}, {4, 0, -1}}));
    }
}
