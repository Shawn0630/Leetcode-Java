package com.search;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    // https://leetcode.com/problems/surrounded-regions/discuss/1552685/Java-or-TC%3A-O(M*N)-or-SC%3A-O(min(MN)-or-Linear-Space-BFS-and-simple-DFS-solutions
    // 0 false 1 true 2 unknown 3 visited
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] isSurrounded;

    // DFS is having some issue
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        isSurrounded = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1) {
                        isSurrounded[i][j] = 0;
                    } else if (j == 0 || j == board[0].length - 1) {
                        isSurrounded[i][j] = 0;
                    } else {
                        isSurrounded[i][j] = 2;
                    }
                } else {
                    isSurrounded[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && IsSurroundedRegions(i, j, board)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solve2(char[][] board) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] isSurrounded = new int[board.length][board[0].length];

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    isSurrounded[i][j] = 2;
                    if (i == 0 || i == board.length - 1 ||
                        j == 0 || j == board[0].length - 1) {
                        queue.add(new int[]{i, j});
                    }
                } else {
                    isSurrounded[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curX = curPos[0];
            int curY = curPos[1];
            isSurrounded[curX][curY] = 0;
            for(int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if (nextX >= 0 && nextX < board.length &&
                    nextY >= 0 && nextY < board[0].length
                    && isSurrounded[nextX][nextY] == 2) {
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && isSurrounded[i][j] == 2) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private boolean IsSurroundedRegions(int x, int y, char[][] board) {
        if (isSurrounded[x][y] == 1) {
            return true;
        } else if (isSurrounded[x][y] == 0) {
            return false;
        }

        isSurrounded[x][y] = 3;

        for(int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= board.length ||
                nextY < 0 || nextY >= board[0].length) {
                isSurrounded[x][y] = 0;
                return false;
            }
            if (isSurrounded[nextX][nextY] != 3) {
                if (!IsSurroundedRegions(nextX, nextY, board)) {
                    isSurrounded[x][y] = 0;
                    return false;
                }
            }
        }

        // requires ans from visited but unknown element

        isSurrounded[x][y] = 1;
        return true;
    }


    public static void main(String[] args) {
        //char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        //char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        char[][] board = {{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};

        SurroundedRegions sr = new SurroundedRegions();
        System.out.println(printChar2DArray(board));
        sr.solve2(board);
        System.out.println(printChar2DArray(board));

    }

    private static String printChar2DArray(char[][] board) {
        StringBuilder sb = new StringBuilder();

        if (board == null || board.length == 0 || board[0].length == 0) {
            return sb.toString();
        }

        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(chars[j])
                    .append(j == board[0].length - 1 ? "\n" : " ");
            }
        }

        return sb.toString();
    }
}
