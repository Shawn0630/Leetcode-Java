package com.array;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SpiralMatrixIITest {

    SpiralMatrixII sm2 = new SpiralMatrixII();

    @Test
    public void test1() {
        assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, sm2.generateMatrix(3));
    }
}
