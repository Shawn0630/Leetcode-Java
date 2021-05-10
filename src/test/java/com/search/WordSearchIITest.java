package com.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WordSearchIITest {

    WordSearchII ws2 = new WordSearchII();

    @Test
    public void test1() {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] input = new String[] {"oath","pea","eat","rain"};

        assertThat(ws2.findWords(board, input), containsInAnyOrder(
                "eat", "oath"
        ));
    }

    @Test
    public void test2() {
        char[][] board = new char[][]{
                {'a', 'a'}
        };

        String[] input = new String[] {"a"};

        assertThat(ws2.findWords(board, input), containsInAnyOrder(
                "a"
        ));
    }

    @Test
    public void test3() {
        char[][] board = new char[][]{
                {'a', 'a'}
        };

        String[] input = new String[] {"aaa"};

        assertEquals(ws2.findWords(board, input), Collections.EMPTY_LIST);
    }
}
