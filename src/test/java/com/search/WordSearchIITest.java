package com.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
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

        assertThat(ws2.findWords(board, input), containsInAnyOrder(Arrays.asList(
                "eat", "oath"
        )));
    }
}
