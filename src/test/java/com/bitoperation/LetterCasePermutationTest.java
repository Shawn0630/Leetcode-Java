package com.bitoperation;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class LetterCasePermutationTest {

    LetterCasePermutation lcp = new LetterCasePermutation();

    @Test
    public void test1() {
        assertThat(lcp.letterCasePermutation("a1b2"), containsInAnyOrder(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2")));
    }

    @Test
    public void test2() {
        assertThat(lcp.letterCasePermutation("3z4"), containsInAnyOrder(Arrays.asList("3z4", "3Z4")));
    }

    @Test
    public void test3() {
        assertThat(lcp.letterCasePermutation("12345"), containsInAnyOrder(Arrays.asList("12345")));
    }
}
