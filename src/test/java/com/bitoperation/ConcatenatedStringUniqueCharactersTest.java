package com.bitoperation;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConcatenatedStringUniqueCharactersTest {
    ConcatenatedStringUniqueCharacters csc = new ConcatenatedStringUniqueCharacters();

    @Test
    public void test1() {
        assertThat(csc.maxLength(Arrays.asList("un","iq","ue")), is(4));
    }

    @Test
    public void test2() {
        assertThat(csc.maxLength(Arrays.asList("cha","r","act","ers")), is(6));
    }

    @Test
    public void test3() {
        assertThat(csc.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")), is(26));
    }
}
