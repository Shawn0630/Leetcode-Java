package com.array.matrix;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    // [    [1,     2,  3],
    //      [4,     5,  6],
    //      [7,     8,  9]
    // ]
    // k = 1, 9 - 1 = 8, the 8th(0-indexing)

    // [
    //      [1],
    //      [2],
    //      [3],
    //      [4],
    //      [7],
    //      [6],
    //      [5]
    // ]
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        k = k % (m * n);
        int idx = (m * n - k) % (m * n);// the nth element from the matrix as starting point k == 0?
        int is =  idx / m;//; start of i index 8 / 3 = 2
        int js = idx % n;//;  start of j index

        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        while (i < m * n) {
            if (i % m == 0) {
                cur = new ArrayList<>();
                ans.add(cur);
            }
            cur.add(grid[is][js]);

            is = js == n - 1 ? (is + 1) % m : is;
            js = (js + 1) % n;

            i++;
        }

        return ans;
    }
}
