package com.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        recursive(matrix, m, n, 0, ans);

        return ans;

    }

    public void recursive(int[][] matrix, int m, int n, int level, List<Integer> ans) {
        if (level >= m - level || level >= n - level) {
            return;
        }

        int i = level;
        int j = level;

        while (j < n - level) {
            ans.add(matrix[i][j]);
            j++;
        }

        j--;
        i++;
        while (i < m - level) {
            ans.add(matrix[i][j]);
            i++;
        }

        i--;
        j--;
        while (j >= level && i > level) {
            ans.add(matrix[i][j]);
            j--;
        }

        j++;
        i--;
        while (i > level && level < n / 2) {
            ans.add(matrix[i][j]);
            i--;
        }

        recursive(matrix, m, n, level + 1, ans);
    }

}
