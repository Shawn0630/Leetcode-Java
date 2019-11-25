package com.search;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordSearchTest {
    WordSearch ws = new WordSearch();

    @Test
    public void test1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(ws.exist(board, "ABCCED"));
        assertTrue(ws.exist(board, "SEE"));
        assertFalse(ws.exist(board, "ABCB"));
    }

    @Test
    public void test2() {
        char[][] board = {
                {'a'}
        };

        assertTrue(ws.exist(board, "a"));
        assertFalse(ws.exist(board, "b"));
    }

    @Test
    public void test3() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        assertTrue(ws.exist(board, "ABCESEEEFS"));
    }
}
