package com.search.breadth_first_search;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (existDFS(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean existDFS(char[][] board, String word, int x, int y, int cur) {

        boolean isFound = false;
        if (board[x][y] == word.charAt(cur)) {
            if (cur == word.length() - 1) {
                return true;
            }
            board[x][y] = '-'; // masking the current element only!!!
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int[] dir : dirs) {
                int nX = x + dir[0];
                int nY = y + dir[1];


                if (nX >= 0 && nX < board.length &&
                    nY >= 0 && nY < board[0].length &&
                    board[nX][nY] != '-') { // not needed, can be check in the next recursive call
                    if (existDFS(board, word, nX, nY, cur + 1)) {
                        isFound = true;
                    }
                }
            }

            board[x][y] = word.charAt(cur);
        }

        return isFound;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'C','A','A'},
                                        {'A','A','A'},
                                        {'B','C','D'}};
        String str = "AAB";
        ws.exist(board, str);
    }
}
