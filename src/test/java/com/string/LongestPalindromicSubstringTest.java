package com.string;

import com.strings.LongestPalindromicSubstring;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestPalindromicSubstringTest {


    LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

    @Test
    public void test1() {
        assertThat(lps.longestPalindrome("babad"), is("bab"));
        assertThat(lps.longestPalindrome2("babad"), is("bab"));
    }

    @Test
    public void test2() {
        assertThat(lps.longestPalindrome("cbbd"), is("bb"));
        assertThat(lps.longestPalindrome2("cbbd"), is("bb"));
    }
}
