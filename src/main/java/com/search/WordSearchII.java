package com.search;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    Trie trie;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || words == null || words.length == 0) {
            return res;
        }

        this.board = board;
        trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j] = true;
                    dfs(res, new StringBuilder().append(board[i][j]), i, j, used);
            }
        }

        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int i, int j, boolean[][] used) {
        if (trie.searchAndDelete(sb.toString())) {
            res.add(sb.toString());
        }
        if (trie.startWith(sb.toString())){
            if (i - 1 >= 0 && !used[i - 1][j]) {
                used[i - 1][j] = true;
                sb.append(board[i - 1][j]);
                dfs(res, sb, i - 1, j, used);
                used[i - 1][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (i + 1 < board.length && !used[i + 1][j]) {
                used[i + 1][j] = true;
                sb.append(board[i + 1][j]);
                dfs(res, sb, i + 1, j, used);
                used[i + 1][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (j - 1 >= 0 && !used[i][j - 1]) {
                used[i][j - 1] = true;
                sb.append(board[i][j - 1]);
                dfs(res, sb, i, j - 1, used);
                used[i][j - 1] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (j + 1 < board[0].length && !used[i][j + 1]) {
                used[i][j + 1] = true;
                sb.append(board[i][j + 1]);
                dfs(res, sb, i, j + 1, used);
                used[i][j + 1] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private class Node {
        Node[] next;
        boolean exist;

        Node() {
            next = new Node[26];
            exist = false;
        }
    }

    private class Trie {
        Node root = new Node();

        public void insert(String str) {
            if (str == null) {
                return;
            }

            Node cur = root;
            char[] cs = str.toCharArray();

            for(char c : cs) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();

                }
                cur = cur.next[c - 'a'];
            }

            cur.exist = true;
        }

        public boolean startWith(String str) {
            if (str == null) {
                return false;
            }

            Node cur = root;
            char[] cs = str.toCharArray();

            for(char c : cs) {
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }

            return true;
        }

        public boolean searchAndDelete(String word) {
            if (word == null) {
                return false;
            }

            char[] cs = word.toCharArray();

            Node cur = root;
            for(char c : cs) {
                if (cur.next[c - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.next[c - 'a'];
                }
            }

            boolean res = cur.exist;
            cur.exist = false;
            return res;
        }

    }
}
