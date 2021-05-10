package com.search;

import com.search.Permutations;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class PermutationTest {
    Permutations p = new Permutations();

    @Test
    public void test1() {
        assertThat(p.permute(new int[]{1, 2, 3}), containsInAnyOrder(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)));
    }

    @Test
    public void test2() {
        assertThat(p.permuteUnique(new int[]{1, 1, 2}), containsInAnyOrder(
                Arrays.asList(1, 1, 2),
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 1, 1)));
    }

    @Test
    public void test3() {
        assertThat(p.permuteUnique(new int[]{2, 2, 1, 1}), containsInAnyOrder(
                Arrays.asList(1, 1, 2, 2),
                Arrays.asList(1, 2, 1, 2),
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(2, 1, 1, 2),
                Arrays.asList(2, 1, 2, 1),
                Arrays.asList(2, 2, 1, 1)));
    }
}
