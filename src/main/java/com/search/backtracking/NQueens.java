package com.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        solve(n, 0, 0, 0, new boolean[n], new boolean[n], new boolean[n + n], new boolean[n + n], board);

        return ans;
    }

    private void solve(int n, int x, int y, int queenCount, boolean[] rows, boolean[] cols, boolean[] diagonal, boolean[] antiDiagonal, char[][] board) {

        if (x == n) {
            if (queenCount == n) {
                ans.add(toArrayList(board));
            }
            return;
        }

        if (!rows[x] && !cols[y] && !diagonal[x + y] && !antiDiagonal[x - y + n]) {
            rows[x] = true;
            cols[y] = true;
            diagonal[x + y] = true;
            antiDiagonal[x - y + n] = true;
            board[x][y] = 'Q';
            solve(n, y + 1 == n ? x + 1 : x, y + 1 == n ? 0 : y + 1, queenCount + 1, rows, cols, diagonal, antiDiagonal, board);
            rows[x] = false;
            cols[y] = false;
            diagonal[x + y] = false;
            antiDiagonal[x - y + n] = false;
            board[x][y] = ' ';
        }
        board[x][y] = '.';
        solve(n, y + 1 == n ? x + 1 : x, y + 1 == n? 0 : y + 1, queenCount, rows, cols, diagonal, antiDiagonal, board);
    }

    private List<String> toArrayList(char[][] board) {
        List<String> ans = new ArrayList<>();
        for(char[] cs : board) {
            ans.add(String.valueOf(cs));
        }

        return ans;
    }
}
