package com.search.binary_search;

import java.util.List;

public class LeftmostColumnwithatLeastaOne {
      // This is the BinaryMatrix's API interface.
      // You should not implement it, or speculate about its implementation
      interface BinaryMatrix {
          public int get(int row, int col);
          public List<Integer> dimensions();
      };


      //[[0,0],
      // [1,1]]

    // [[0, 0, 0, 1]
    //  [0, 1, 1, 1]]


    // [[0, 0, 1, 1]
    //  [0, 0, 0, 1]]
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int row = dimension.get(0);
        int col = dimension.get(1);
        int leftmost = col;

        for(int i = 0; i < row; i++) {
            int left = 0, right = leftmost - 1;

            //0     1   2   3   4
            //[0    0   0   0   1]
            // l                r
            //          m
            //              l   r
            //              m
            //                  l

            //[1]
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (binaryMatrix.get(i, left) == 1) {
                leftmost = Math.min(leftmost, left);
            }
        }

        return leftmost == col ? -1 : leftmost;
    }
}
