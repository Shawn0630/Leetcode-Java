package com.math;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PermutationSequenceTest {

    PermutationSequence ps = new PermutationSequence();

    @Test
    public void test1() {
        assertThat(ps.getPermutation(3, 3), is("213"));
    }

    @Test
    public void test2() {
        assertThat(ps.getPermutation(4, 9), is("2314"));
    }

    @Test
    public void test3() {
        assertThat(ps.getPermutation(1, 1), is("1"));
    }

    @Test
    public void test4() {
        assertThat(ps.getPermutation(2, 2), is("21"));
    }
}
