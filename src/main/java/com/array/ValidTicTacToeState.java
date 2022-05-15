package com.array;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int player1 = 0;
        int player2 = 0;

        int[] row = new int[3];
        int[] col = new int[3];
        int diagnol = 0;
        int antiDiagnol = 0;
        //  0   1   (0,2)
        //  0   (1,1)   2

        // ["XXO",
        //  "XOX",
        //  "OXO"]
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    player1++;
                    row[i]++;
                    col[j]++;
                    if (i == j) {
                        diagnol++;
                    }
                    if (i + j + 1 == 3) {
                        antiDiagnol++;
                    }
                } else if (board[i].charAt(j) == 'O') {
                    player2++;
                    row[i]--;
                    col[j]--;
                    if (i == j) {
                        diagnol--;
                    }
                    if (i + j + 1 == board.length) {
                        antiDiagnol--;
                    }
                }
            }
        }

        if (player1 > player2 + 1 || player2 > player1) {
            return false;
        }

        boolean player1Win = false;
        boolean player2Win = false;
        for(int i = 0; i < 3; i++) {
            if (row[i] == 3) {
                player1Win = true;
                break;
            }
            if (row[i] == -3) {
                player2Win = true;
                break;
            }
            if (col[i] == 3) {
                player1Win = true;
                break;
            }
            if (col[i] == -3) {
                player2Win = true;
                break;
            }
        }

        player1Win = player1Win || (diagnol == 3) || (antiDiagnol == -3);
        player2Win = player2Win || (diagnol == -3) || (antiDiagnol == -3);

        if (player1Win) {
            return player1 == player2 + 1;
        }
        if (player2Win) {
            return player1 == player2;
        }

        return true;
    }
}
