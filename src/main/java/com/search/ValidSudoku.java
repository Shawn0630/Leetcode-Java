package com.search;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 &&
            board[0] == null || board[0].length != 9) {
            return false;
        }

        for(int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cell = new HashSet<>();
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;

                int nx = 3 * (i / 3);
                int ny = 3 * (i % 3);

                if (board[nx + j  / 3][ny + j % 3] != '.' && !cell.add(board[nx + j  / 3][ny + j % 3])) return false;
            }
        }

        return true;
    }
}
