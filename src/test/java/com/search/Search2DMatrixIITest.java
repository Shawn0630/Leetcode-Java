package com.search;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Search2DMatrixIITest {
    Search2DMatrixII search2DMatrixII = new Search2DMatrixII();

    @Test
    public void test1() {
        int[][] matrix = new int[][] {{1,4},{2,5}};
        assertTrue(search2DMatrixII.searchMatrix(matrix, 2));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        assertTrue(search2DMatrixII.searchMatrix(matrix, 5));
    }
}
