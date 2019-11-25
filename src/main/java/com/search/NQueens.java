package com.search;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    boolean[] col;
    boolean[] diagonal1;
    boolean[] diagonal2;
    char[][] cs;
    int count;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];

        cs = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cs[i][j] = '.';
            }
        }

        dfs(0, n, res);

        return res;
    }

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        count = 0;

        dfsCount(0, n);

        return count;
    }

    private void updateBoard(int n, int x, int y, boolean set) {
        col[y] = set;
        diagonal1[x + y] = set;
        diagonal2[x - y + n - 1] = set;
        cs[x][y] = set ? 'Q' : '.';
    }

    private boolean available(int x, int y, int n) {
        return !col[y] && !diagonal1[x + y] && !diagonal2[x - y + n - 1] && cs[x][y] != 'Q';
    }

    private List<String> convertStringList(char[][] board) {
        if (board == null) {
            return null;
        }


        List<String> res = new ArrayList<>();
        for (char[] aBoard : board) {
            StringBuilder sb = new StringBuilder();
            for(char c : aBoard) {
                sb.append(c);
            }
            res.add(sb.toString());
        }

        return res;

    }


    private void dfs(int cur, int n, List<List<String>> res) {
        if (cur == n) {
            res.add(convertStringList(cs));
        }

        for(int i = 0; i < n; i++) {
            if (available(cur, i, n)) {
                updateBoard(n, cur, i, true);
                dfs(cur + 1, n, res);
                updateBoard(n, cur, i, false);
            }
        }
    }

    private void dfsCount(int cur, int n) {
        if (cur == n) {
            count++;
        }

        for(int i = 0; i < n; i++) {
            if (available(cur, i, n)) {
                updateBoard(n, cur, i, true);
                dfsCount(cur + 1, n);
                updateBoard(n, cur, i, false);
            }
        }
    }
}
