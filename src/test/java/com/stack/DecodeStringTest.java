package com.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DecodeStringTest {

    DecodeString ds;

    @Before
    public void setup() {
        ds = new DecodeString();
    }

    @Test
    public void test1() {
        assertThat(ds.decodeString("3[a]2[bc]"), is("aaabcbc"));
        assertThat(ds.decodeString2("3[a]2[bc]"), is("aaabcbc"));
        assertThat(ds.decodeString3("3[a]2[bc]"), is("aaabcbc"));
    }

    @Test
    public void test2() {
        assertThat(ds.decodeString("3[a2[c]]"), is("accaccacc"));
        assertThat(ds.decodeString2("3[a2[c]]"), is("accaccacc"));
        assertThat(ds.decodeString3("3[a2[c]]"), is("accaccacc"));
    }

    @Test
    public void test3() {
        assertThat(ds.decodeString("2[abc]3[cd]ef"), is("abcabccdcdcdef"));
        assertThat(ds.decodeString2("2[abc]3[cd]ef"), is("abcabccdcdcdef"));
        assertThat(ds.decodeString3("2[abc]3[cd]ef"), is("abcabccdcdcdef"));
    }

    @Test
    public void test4() {
        assertThat(ds.decodeString("3[a]2[b4[F]c]"), is("aaabFFFFcbFFFFc"));
        assertThat(ds.decodeString2("3[a]2[b4[F]c]"), is("aaabFFFFcbFFFFc"));
        assertThat(ds.decodeString3("3[a]2[b4[F]c]"), is("aaabFFFFcbFFFFc"));
    }
}
