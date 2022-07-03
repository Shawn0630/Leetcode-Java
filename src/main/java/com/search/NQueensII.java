package com.search;

public class NQueensII {
    //
    // 0    0   0   0
    // 0    0   0   0
    // 0    0   0   0
    // 0    0   0   0

    // boolean[] col;
    // boolean[] diagonal ~ 2 * n - 1
    // x + y = 0
    // x + n - 1 - y = 0 + 3 - 0 = 3
    // diagonal indexing

    int total;
    public int totalNQueens(int n) {
        total = 0;
        totalNQueens(n, 0, 0, 0, new boolean[n], new boolean[n], new boolean[2 * n], new boolean[2 * n]);

        return total;
    }

    private void totalNQueens(int n, int cur, int x, int y, boolean[] rows, boolean[] cols, boolean[] diagnoal, boolean[] antiAiagnoal) {
        if (x == n)  {
            if (cur == n) {
                total++;
            }
            return;
        }

        if (!rows[x] && !cols[y] && !diagnoal[x + y] && !antiAiagnoal[x - y + n]) {
            rows[x] = true;
            cols[y] = true;
            diagnoal[x + y] = true;
            antiAiagnoal[x - y + n] = true;
            totalNQueens(n, cur + 1, y + 1 == n? x + 1 : x, y + 1 == n? 0 : y + 1, rows, cols, diagnoal, antiAiagnoal);
            rows[x] = false;
            cols[y] = false;
            diagnoal[x + y] = false;
            antiAiagnoal[x - y + n] = false;
        }
        totalNQueens(n, cur, y + 1 == n? x + 1 : x, y + 1 == n? 0 : y + 1, rows, cols, diagnoal, antiAiagnoal);
    }
}
