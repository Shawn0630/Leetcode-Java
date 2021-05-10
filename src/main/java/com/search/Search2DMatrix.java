package com.search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int index = findRow(matrix, target);

        return index >= 0 && findInRow(matrix[index], target);
    }

    private int findRow(int[][] matrix, int target) {
        int m = matrix.length;

        int left = 0;
        int right = m - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) right = mid;
            else if (matrix[mid][0] < target) left = mid + 1;
            else {
                return mid;
            }
        }

        return matrix[left][0] <= target ? left : left - 1;
    }

    private boolean findInRow(int[] array, int target) {
        int m = array.length;

        int left = 0;
        int right = m - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) right = mid;
            else if (array[mid] < target) left = mid + 1;
            else {
                return true;
            }
        }

        return array[left] == target;
    }
}
