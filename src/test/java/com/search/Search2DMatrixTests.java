package com.search;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Search2DMatrixTests {

    Search2DMatrix s2m = new Search2DMatrix();

    @Test
    public void test1() {
        assertTrue(s2m.searchMatrix(new int[][]{
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}}, 3));
    }


    @Test
    public void test2() {
        assertFalse(s2m.searchMatrix(new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}}, 13));
    }

    @Test
    public void test3() {
        assertFalse(s2m.searchMatrix(new int[][]{{1}}, 0));
    }

    @Test
    public void test4() {
        assertTrue(s2m.searchMatrix(new int[][]{{1}}, 1));
    }
}
