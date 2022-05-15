package com.search;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int low_x0 = 0, low_x1 = 0;
        int high_x0 = matrix.length - 1, high_x1 = matrix[0].length - 1;

       return searchMatrix(matrix, target, low_x0, low_x1, high_x0, high_x1);
    }


    // https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66147/*Java*-an-easy-to-understand-divide-and-conquer-method
    public boolean searchMatrix(int[][] matrix, int target, int low_x0, int low_x1, int high_x0, int high_x1) {
        if (low_x0 > high_x0 || low_x1 > high_x1) {
            return false;
        } else if (low_x0 == high_x0 && low_x1 == high_x1) {
            return matrix[low_x0][low_x1] == target;
        } else {
                int mid_x0 = low_x0 + (high_x0 - low_x0) / 2;
                int mid_x1 = low_x1 + (high_x1 - low_x1) / 2;

                if (matrix[mid_x0][mid_x1] == target) {
                    return true;
                } else if (matrix[mid_x0][mid_x1] > target) {
                    return searchMatrix(matrix, target, low_x0, low_x1, mid_x0, mid_x1) ||
                            searchMatrix(matrix, target, low_x0, mid_x1 + 1, high_x0, high_x1) ||
                            searchMatrix(matrix, target, mid_x0 + 1, low_x1, high_x0, high_x1);
                } else {
//                low_x0 = mid_x0 + 1;
//                low_x1 = mid_x1 + 1; // will skip some elemnts e.g. {{1,4},{2,5}}, skipping 4 and 2
                    return searchMatrix(matrix, target, mid_x0 + 1, mid_x1 + 1, high_x0, high_x1) ||
                            searchMatrix(matrix, target, low_x0, mid_x1 + 1, high_x0, high_x1) ||
                            searchMatrix(matrix, target, mid_x0 + 1, low_x1, high_x0, high_x1);
                }
            }
//        } else {
//            if (low_x0 >= high_x0) {
//                while (low_x1 < high_x1) {
//                    int mid = low_x1 + (high_x1 - low_x1) / 2;
//                    if (target == matrix[low_x0][mid]) {
//                        return true;
//                    } else if (matrix[low_x0][mid] > target) {
//                        high_x1 = mid;
//                    } else {
//                        low_x1 = mid + 1;
//                    }
//                }
//            } else {
//                while (low_x0 < high_x0) {
//                    int mid = low_x0 + (high_x0 - low_x0) / 2;
//                    if (target == matrix[mid][low_x1]) {
//                        return true;
//                    } else if (matrix[mid][low_x1] > target) {
//                        high_x0 = mid;
//                    } else {
//                        low_x0 = mid + 1;
//                    }
//                }
//            }
//
//            return matrix[low_x0][low_x1] == target;
//        }
    }

    // m[i][j] < m[i + 1][j]
    // m[i][j] < m[i][j + 1]

    // m[ileft][jleft] < target < m[iend][jend] => true, otherwise false
    // each search interval should satisfy the rule.
    // imid = (ileft + iend) / 2 ...
    // case#1: [imid, jmid] = target return true
    // case#2: [imid, jmid] < target istart = imid || jstart = jmid
    // case#3: [imid, jmid] > target [istart, jstart] -> [imid, jmid]
    public boolean searchMatrix2(int[][] matrix, int target) {
        return searchMatrix2DFS(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean searchMatrix2DFS(int[][] matrix, int target, int iStart, int jStart, int iEnd, int jEnd) {
        if (iStart < 0 || iEnd >= matrix.length ||
            jStart < 0 || jEnd >= matrix[0].length ||
            iStart > iEnd || jStart > jEnd) {
            return false;
        }

        int iMid = iStart + (iEnd - iStart) / 2;
        int jMid = jStart + (jEnd - jStart) / 2;

        if (matrix[iMid][jMid] == target) {
            return true;
        } else if (matrix[iMid][jMid] < target) {
            return searchMatrix2DFS(matrix, target, iMid + 1, jStart, iEnd, jEnd) || searchMatrix2DFS(matrix, target, iStart, jMid + 1, iEnd, jEnd);
        } else {
            return searchMatrix2DFS(matrix, target, iStart, jStart, iEnd, jMid - 1) || searchMatrix2DFS(matrix, target, iStart, jStart, iMid - 1, jEnd);
        }
    }
}
