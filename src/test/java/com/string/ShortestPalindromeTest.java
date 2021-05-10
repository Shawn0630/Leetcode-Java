package com.string;

import com.strings.ShortestPalindrome;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShortestPalindromeTest {
    ShortestPalindrome sp = new ShortestPalindrome();

    @Test
    public void test1() {
        assertThat(sp.shortestPalindrome("aacecaaa"), is("aaacecaaa"));
    }

    @Test
    public void test2() {
        assertThat(sp.shortestPalindrome("abcd"), is("dcbabcd"));
    }
}
