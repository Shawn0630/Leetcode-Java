package com.array;

public class DiagonalTraverse {

    // [[1,     2,      3],
    //  [4,     5,      6],
    //  [7,     8,      9]]

    // assumptions/constraints
    // 1. no empty matrix/null matrix

    // intuition
    // option #1 simulation
    // option #2
    public int[] findDiagonalOrder(int[][] mat) {
        int[][] dirs = new int[][]{{-1, 1}, {1, -1}}; // upward, downward

        int m = mat.length;
        int n = mat[0].length;
        int[] array = new int[m * n]; // row >= 1
        int idx = 0;

        int x = 0, y = 0;
        int curDir = 0;

        while (idx < m * n) {
            array[idx++] = mat[x][y];

            int nextX = x + dirs[curDir][0];
            int nextY = y + dirs[curDir][1];



            if (nextX < 0 || nextX >= m ||
                nextY < 0 || nextY >= n) { // (0, 0) => (-1, 1) => (0, 1)  (1, 0) => (2, -1) => (2, 0)      (0, 2) => (-1, 3) => (1, 2)
                if (curDir == 0) { // will only reach the top or rightmost side
                    if (nextY >= n) { // rightmost, move to the next row
                        nextX = x + 1;
                        nextY = n - 1;
                    } else { // top, move to the next col
                        nextX = x;
                        nextY = y + 1;
                    }
                    curDir = 1;
                } else { // curDir == 1, will only reach the bottom or leftmost side
                    if (nextX >= m) { // bottom, move to the next col
                        nextX = x;
                        nextY = y + 1;
                    } else { // leftmost, move to the next row
                        nextX = x + 1;
                        nextY = 0;
                    }
                    curDir = 0;
                }
            }

            x = nextX;
            y = nextY;

        }

        return array;
    }

    public int[] findDiagonalOrder2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int px = 0;

        for(int i = 0; i < mat[0].length + mat.length - 1; i++) {
            int x = i >= mat[0].length ? i - mat[0].length + 1 : 0; // 3 - 3 + 1
            int y = i >= mat[0].length ? mat[0].length - 1 : i;
            int[] row = new int[m * n];
            int idx = 0;

            while (x >= 0 && x < m && y >= 0 && y < n) {
                row[idx++] = mat[x][y];
                x = x + 1;
                y = y - 1;
            }

            if (i % 2 == 1) {
                for(int j = 0; j < idx; j++) {
                   ans[px++] = row[j];
                }
            } else {
                for(int j = idx - 1; j >= 0; j--) {
                    ans[px++] = row[j];
                }
            }
        }

        return ans;
    }
}
