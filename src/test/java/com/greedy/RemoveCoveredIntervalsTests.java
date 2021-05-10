package com.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveCoveredIntervalsTests {
    RemoveCoveredIntervals rci = new RemoveCoveredIntervals();

    @Test
    public void test1() {
        int[][] intervals = new int[][]{
            {1,4},
            {3,6},
            {2,8}
        };
        int expected = 2;
        assertEquals(expected, rci.removeCoveredIntervals(intervals));
    }

    @Test
    public void test2() {
        int[][] intervals = new int[][]{
            {1,4},
            {2,3}
        };
        int expected = 1;
        assertEquals(expected, rci.removeCoveredIntervals(intervals));
    }

    @Test
    public void test3() {
        int[][] intervals = new int[][]{
            {0,10},
            {5,12}
        };
        int expected = 2;
        assertEquals(expected, rci.removeCoveredIntervals(intervals));
    }

    @Test
    public void test4() {
        int[][] intervals = new int[][]{
            {3,10},
            {4,10},
            {5,11}
        };
        int expected = 2;
        assertEquals(expected, rci.removeCoveredIntervals(intervals));
    }

    @Test
    public void test5() {
        int[][] intervals = new int[][]{
            {1,2},
            {1,4},
            {3,4}
        };
        int expected = 1;
        assertEquals(expected, rci.removeCoveredIntervals(intervals));
    }

    @Test
    public void test6() {
        int[][] intervals = new int[][]{
            {66672,75156},
            {59890,65654},
            {92950,95965},
            {9103,31953},
            {54869,69855},
            {33272,92693},
            {52631,65356},
            {43332,89722},
            {4218,57729},
            {20993,92876}
        };
        int expected = 3;
        assertEquals(expected, rci.removeCoveredIntervals(intervals));

    }
}
