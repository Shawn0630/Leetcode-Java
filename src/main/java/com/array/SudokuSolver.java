package com.array;

public class SudokuSolver {

    //  [0,0]   [0,1],  [0,2]
    //  [1,0]   [1,1],  [1,2]  => 1  ... 2...3
    //  [2,0]   [2,1],  [2,2]

    //  [3,0] => 3 / 3 * 3 + 4 .. 5 .. 6

    // [6,0] => 6 / 3
    //  7 .. 8 .. 10

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[10][10];
        boolean[][] cols = new boolean[10][10];
        boolean[][] boards = new boolean[10][10];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '0';
                    rows[i][value] = true;
                    cols[j][value] = true;

                    int boardIndex = (i / 3) * 3 + (j / 3) + 1;
                    boards[boardIndex][value] = true;
                }
            }
        }

        dfs(board, 0, 0, rows, cols, boards);
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] rows, boolean[][] cols, boolean[][] boards) {
        if (i == 9) {
            return true;
        }
        int ni = i == 8 ? 0 : i + 1;
        int nj = i == 8 ? j + 1 : j;

        if (board[i][j] == '.') {
            int boardIndex = (i / 3) * 3 + (j / 3) + 1;
            for(int k = 1; k <= 9; k++) {
                if (!rows[i][k] && !cols[j][k] && !boards[boardIndex][k]) {
                    rows[i][k] = true;
                    cols[j][k] = true;
                    boards[boardIndex][k] = true;
                    board[i][j] = (char) (k + '0');

                    if (dfs(board, ni, nj, rows, cols, boards)) return true;

                    rows[i][k] = false;
                    cols[j][k] = false;
                    boards[boardIndex][k] = false;
                    board[i][j] = '.';
                }
            }

            return false;
        } else {
            return dfs(board, ni, nj, rows, cols, boards);
        }
    }
}
