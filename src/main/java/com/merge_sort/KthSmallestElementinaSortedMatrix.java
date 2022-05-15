package com.merge_sort;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return -1;
        }

        int[] cur_indexes = new int[matrix.length];
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        for(int i = 0; i < matrix.length; i++) {
            cur_indexes[i] = 0;
            queue.offer(new Pair<>(i, matrix[i][0]));
        }

        int cur = 0;
        while (k > 0 && !queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            Integer row = pair.getKey();
            cur = pair.getValue();
            if (cur_indexes[row] < matrix[0].length - 1) {
                queue.offer(new Pair<>(row, matrix[row][++cur_indexes[row]]));
            }
            k--;
        }

        return cur;
    }
}
