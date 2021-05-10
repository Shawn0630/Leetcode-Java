package com.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeWaysTests {

    DecodeWays dw = new DecodeWays();

    @Test
    public void test1() {
        assertEquals(2, dw.numDecodings("12"));
        assertEquals(2, dw.numDecodings2("12"));
    }

    @Test
    public void test2() {
        assertEquals(3, dw.numDecodings("226"));
        assertEquals(3, dw.numDecodings2("226"));
    }

    @Test
    public void test3() {
        assertEquals(0, dw.numDecodings("0"));
        assertEquals(0, dw.numDecodings2("0"));
    }

    @Test
    public void test4() {
        assertEquals(0, dw.numDecodings("1000"));
        assertEquals(0, dw.numDecodings("1000"));
    }

    @Test
    public void test5() {
        assertEquals(1, dw.numDecodings("101"));
        assertEquals(1, dw.numDecodings2("101"));
    }

    @Test
    public void test6() {
        assertEquals(9, dw.numDecodings2("*"));
    }

    @Test
    public void test7() {
        assertEquals(18, dw.numDecodings2("1*"));
    }

    @Test
    public void test8() {
        assertEquals(11, dw.numDecodings2("*1"));
    }

    @Test
    public void test9() {
        assertEquals(18720, dw.numDecodings2("**1**"));
    }

    @Test
    public void test10() {
        assertEquals(36, dw.numDecodings2("*0**0"));
    }

    @Test
    public void test11() {
        assertEquals(291868912, dw.numDecodings2("*********"));
    }

    @Test
    public void test12() {
        assertEquals(133236775, dw.numDecodings3("**********1111111111"));
        assertEquals(133236775, dw.numDecodings2("**********1111111111"));

    }
}
