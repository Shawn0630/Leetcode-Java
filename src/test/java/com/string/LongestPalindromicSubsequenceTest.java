package com.string;

import com.strings.LongestPalindromicSubsequence;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LongestPalindromicSubsequenceTest {

    LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

    @Test
    public void test1() {
        assertThat(lps.longestPalindromeSubseq("bbbab"), is(4));
    }

    @Test
    public void test2() {
        assertThat(lps.longestPalindromeSubseq("cbbd"), is(2));
    }

}
