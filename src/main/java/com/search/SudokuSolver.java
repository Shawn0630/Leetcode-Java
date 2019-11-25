package com.search;

import java.util.*;

public class SudokuSolver {
    private List<Set<Integer>> rows = new ArrayList<>();
    private List<Set<Integer>> cols = new ArrayList<>();
    private List<Set<Integer>> boxes = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 ||
            board[0] == null || board[0].length != 9) {
            return;
        }

        for(int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows.get(i).add(board[i][j] - '0');
                    cols.get(j).add(board[i][j] - '0');
                    boxes.get(i / 3 * 3 + j / 3).add(board[i][j] - '0');
                }
            }
        }

        dfs(0, 0, board);
    }

    private void updateBoard(int x, int y, int num, char[][] board, boolean put) {
        if (put) {
            rows.get(x).add(num);
            cols.get(y).add(num);
            boxes.get(x / 3 * 3 + y / 3).add(num);
            board[x][y] = (char)(num + '0');
        } else {
            rows.get(x).remove(num);
            cols.get(y).remove(num);
            boxes.get(x / 3 * 3 + y / 3).remove(num);
            board[x][y] = '.';
        }

    }

    private boolean available(int x, int y, int num) {
        return !rows.get(x).contains(num) && !cols.get(y).contains(num) && !boxes.get(x / 3 * 3 + y / 3).contains(num);
    }

    private boolean dfs(int x, int y, char[][] board) {
        if(x == 9) {
            return true;
        }
        int nx = y + 1 == 9 ? x + 1 : x;
        int ny = (y + 1) % 9;

        if (board[x][y] != '.') {
            return dfs(nx, ny, board);
        } else {
            for(int i = 1; i <= 9; i++) {
                if (available(x, y, i)) {
                    updateBoard(x, y, i, board, true);
                    if (dfs(nx, ny, board)) return true;
                    updateBoard(x, y, i, board, false);
                }
            }
        }

        return false;
    }
}
