package com.string;

import com.strings.PalindromicSubstrings;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PalindromicSubstringsTest {
    PalindromicSubstrings ps = new PalindromicSubstrings();

    @Test
    public void test1() {
        assertThat(ps.countSubstrings("aaa"), is(6));
        assertThat(ps.countSubstrings2("aaa"), is(6));
    }

    @Test
    public void test2() {
        assertThat(ps.countSubstrings("abc"), is(3));
        assertThat(ps.countSubstrings2("abc"), is(3));
    }
}
