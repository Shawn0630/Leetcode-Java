package com.search;

import java.util.Arrays;

public class WordSearch {
    char[][] board;
    String word;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        this.board = board;
        this.word = word;
        used = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {

                if (dfs_2(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int cur) {
        if (cur == word.length()) {
            return true;
        }

        if (board[x][y] == word.charAt(cur)) {

            used[x][y] = true;
            int pr = Math.max(0, x - 1);
            int nr = Math.min(board.length - 1, x + 1);
            int pc = Math.max(0, y - 1);
            int nc = Math.min(board[x].length - 1, y + 1);


            if (cur == word.length() - 1) {
                return true;
            }

            boolean found = (!used[pr][y] && dfs(pr, y, cur + 1)) ||
                    (!used[nr][y] && dfs(nr, y, cur + 1)) ||
                    (!used[x][pc] && dfs(x, pc, cur + 1)) ||
                    (!used[x][nc] && dfs(x, nc, cur + 1));

            if (!found) {
                used[x][y] = false;
            }

            return found;

        }

        return false;
    }

    private boolean dfs_2(int x, int y, int cur) {
        if (cur == word.length()) {
            return true;
        }

        if (x >= board.length || x < 0 ||
            y >= board[0].length || y < 0 ||
            used[x][y] || board[x][y] != word.charAt(cur)) {
            return false;
        }

        used[x][y] = true;

        boolean found = dfs_2(x + 1, y, cur + 1) || dfs_2(x - 1, y, cur + 1) ||
               dfs_2(x, y + 1, cur + 1) || dfs_2(x, y - 1, cur + 1);
        used[x][y] = false;

        return found;
    }
}
