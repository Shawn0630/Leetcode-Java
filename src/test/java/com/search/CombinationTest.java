package com.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;


public class CombinationTest {
    Combination c = new Combination();

    @Test
    public void test1() {
        assertThat(c.combine(4, 2), containsInAnyOrder(
            Arrays.asList(2, 4),
            Arrays.asList(3, 4),
            Arrays.asList(2, 3),
            Arrays.asList(1, 2),
            Arrays.asList(1, 3),
            Arrays.asList(1, 4)
        ));
    }
}
