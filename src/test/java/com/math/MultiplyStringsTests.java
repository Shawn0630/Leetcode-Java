package com.math;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyStringsTests {

    MultiplyStrings ms = new MultiplyStrings();

    @Test
    public void test1() {
        assertEquals("6", ms.multiply("2", "3"));
    }

    @Test
    public void test2() {
        assertEquals("56088", ms.multiply("123", "456"));
    }


    @Test
    public void test3() {
        assertEquals("0", ms.multiply("123", "0"));
    }
}
