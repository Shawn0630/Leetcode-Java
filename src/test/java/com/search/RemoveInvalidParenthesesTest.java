package com.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class RemoveInvalidParenthesesTest {

    RemoveInvalidParentheses rip = new RemoveInvalidParentheses();

    @Test
    public void test1() {
        assertThat(rip.removeInvalidParentheses("()())()"), containsInAnyOrder(
                "()()()", "(())()"
        ));
    }

    @Test
    public void test2() {
        assertThat(rip.removeInvalidParentheses("(a)())()"), containsInAnyOrder(
                "(a)()()", "(a())()"
        ));
    }

    @Test
    public void test3() {
        assertThat(rip.removeInvalidParentheses(")("), containsInAnyOrder(""));
    }
}
