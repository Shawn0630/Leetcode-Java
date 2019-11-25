package com.bitoperation;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class SingleNumberTest {

    SingleNumber sn = new SingleNumber();
    SingleNumberIII sn3 = new SingleNumberIII();

    @Test
    public void test1() {
        assertThat(sn.singleNumber(new int[]{2, 2, 1}), is(1));
    }

    @Test
    public void test2() {
        assertThat(sn.singleNumber(new int[]{4, 1, 2, 1, 2}), is(4));
    }

    @Test
    public void test3() {
        assertThat(sn.singleNumber(new int[]{-4, 1, 2, 1, 2}), is(-4));
    }

    @Test
    public void test4() {
        assertThat(sn.singleNumber(new int[]{-1, -1, -2}), is(-2));
    }

    @Test
    public void test5() {
        int[] actual = sn3.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        int[] expect = new int[]{3, 5};
        Arrays.sort(actual);
        Arrays.sort(expect);
        assertArrayEquals(actual, expect);
    }
}
