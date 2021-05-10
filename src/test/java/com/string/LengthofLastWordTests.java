package com.string;

import com.strings.LengthofLastWord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthofLastWordTests {

    LengthofLastWord lolw = new LengthofLastWord();

    @Test
    public void test1() {
        assertEquals(1, lolw.lengthOfLastWord("Test    Test     t   "));
    }
}
