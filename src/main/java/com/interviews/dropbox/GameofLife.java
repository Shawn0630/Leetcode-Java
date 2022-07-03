package com.interviews.dropbox;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int liveCount = 0;
                for(int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                        if ((board[ni][nj] & 1) == 1) {
                            liveCount++;
                        }
                    }
                }
                int curState = board[i][j] & 1;
                if (curState == 1) {
                    if (liveCount == 2 || liveCount == 3) {
                        board[i][j] |= 2;
                    }
                } else {
                    if (liveCount == 3) {
                        board[i][j] |= 2;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
