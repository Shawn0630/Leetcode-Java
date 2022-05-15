package com.system_design;

import java.util.HashSet;
import java.util.Set;

public class TicTacToe {
    int[][] grid;
    int counter;
    public TicTacToe(int n) {
        grid = new int[n][n];
        counter = 0;
    }

    public int move(int row, int col, int player) {
        grid[row][col] = player;
        if (counter == grid.length * grid.length) return 2;
        return isFinished(row, col, player, grid);
    }


    //  0   0   0   0
    //  0   0   0   0
    //  0   0   0   0
    //  0   0   0   0
    private int isFinished(int row, int col, int player, int[][] grid) {
        boolean rowMatch = true;
        boolean rowOccupy = true;
        boolean colMatch = true;
        boolean colOccupy = true;
        boolean horiMatch1 = true;
        boolean horiOccupy1 = true;
        boolean horiMatch2 = true;
        boolean horiOccupy2 = true;
        for(int i = 0; i < grid.length; i++) {
            if (grid[row][i] != player) {
                rowMatch = false;
            }
            if (grid[row][i] == 0) {
                rowOccupy = false;
            }
            if (grid[i][col] != player) {
                colMatch = false;
            }
            if (grid[i][col] == 0) {
                colOccupy = false;
            }
            if (grid[i][i] != player) {
                horiMatch1 = false;
            }
            if (grid[i][i] == 0) {
                horiOccupy1 = false;
            }
            if (grid[grid.length - 1 - i][i] != player) {
                horiMatch2 = false;
            }
            if (grid[grid.length - 1 - i][i] == 0) {
                horiOccupy2 = false;
            }
        }

        if (rowOccupy && colOccupy && horiOccupy1 && horiOccupy2) {

        }

        if (rowMatch || colMatch || horiMatch1 || horiMatch2) {
            return 1;
        } else {
            return 0;
        }
    }
}
