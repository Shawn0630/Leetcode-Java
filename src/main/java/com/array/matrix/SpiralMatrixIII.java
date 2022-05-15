package com.array.matrix;

public class SpiralMatrixIII {
    // [0   0   0|1   0|2]
    // [0   0   0   0]
    // https://leetcode.com/problems/spiral-matrix-iii/discuss/158970/C%2B%2BJavaPython-112233-Steps
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int length = 1;
        int[][] matrix = new int[rows * cols][2];

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int idx = 1;
        int i = rStart;
        int j = cStart;
        int cur = length;
        int curDir = 0;
        boolean needSwitch = false;
        matrix[0] = new int[]{rStart, cStart};
        while (idx < rows * cols) {
            i = i + dirs[curDir][0];
            j = j + dirs[curDir][1];

            cur--;
            if (cur == 0) {
                curDir = (curDir + 1) % 4;
                if (needSwitch) {
                    length = length + 1;
                }
                cur = length;
                needSwitch = !needSwitch;
            }

            if (i >= 0 && i < rows && j >= 0 && j < cols) {
                matrix[idx++] = new int[]{i, j};
            }

        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixIII spiralMatrixII = new SpiralMatrixIII();
        spiralMatrixII.spiralMatrixIII(1, 4, 0, 0);
    }
}
