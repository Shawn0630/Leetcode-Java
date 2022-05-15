package com.search.breadth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    // https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            root.addWord(word);
        }

        Set<String> res = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                addWord(root, i, j, board, new StringBuilder(), res);
            }
        }

        return new ArrayList<>(res);
    }

    private void addWord(Trie root, int x, int y, char[][] board, StringBuilder sb, Set<String> word) {
        if (x < 0 || x >= board.length ||
            y < 0 || y >= board[0].length ||
            board[x][y] == '-' || root == null) {
            return;
        }
        char c = board[x][y];

        board[x][y] = '-';
        sb.append(c);
        Trie newRoot = root.tries[c - 'a'];

        if (newRoot == null) {
            board[x][y] = c;
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if (newRoot.isWord) {
            word.add(sb.toString());
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] dir : dirs) {
            addWord(newRoot, x + dir[0], y + dir[1], board, sb, word);
        }

        board[x][y] = c;
        sb.deleteCharAt(sb.length() - 1);
    }

    private class Trie {
        Trie[] tries;
        boolean isWord;

        public Trie() {
            tries = new Trie[26];
            isWord = false;
        }

        public void addWord(String word) {
            Trie cur = this;
            for(char c : word.toCharArray()) {
                if (cur.tries[c - 'a'] == null) {
                    cur.tries[c - 'a'] = new Trie();
                }
                cur = cur.tries[c - 'a'];
            }
            cur.isWord = true;
        }
    }
}
