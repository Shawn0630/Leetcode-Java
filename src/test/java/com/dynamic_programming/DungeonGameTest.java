package com.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DungeonGameTest {

    DungeonGame dg = new DungeonGame();

    @Test
    public void test1() {
        assertThat(dg.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}), is(7));
    }
}
