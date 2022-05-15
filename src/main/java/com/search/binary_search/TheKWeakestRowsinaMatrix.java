package com.search.binary_search;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsinaMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] lastOne = new int[mat.length];
        int[] order = new int[mat.length];
        int idx = 0;
        for(int[] array : mat) {
            lastOne[idx] = lastOne(array);
            order[idx] = idx;
            idx++;
        }


        return topK(order, lastOne, k);
    }

    public int[] kWeakestRows2(int[][] mat, int k) {
        int[] lastOne = new int[mat.length];
        int idx = 0;
        // 0 - lastOne
        // 1 - index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        // 2, 1, 3, 4, 5 k = 3
        // 2 => 1, 2 => 1, 2, 3 =>
        // 2 => 2, 1 => 3, 2, 1 => {4} 3, 2, 1 =>
        for(int[] array : mat) {
            priorityQueue.offer(new int[]{lastOne(array), idx++});

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        idx = k - 1;
        int[] ans = new int[k];
        while (!priorityQueue.isEmpty()) {
            ans[idx--] = priorityQueue.poll()[1];
        }

        return ans;
    }

    private int[] topK(int[] order, int[] lastOne, int k) {
        int left = 0, right = lastOne.length - 1;
        while (left <= right) {
            int pos = quickSelect(order, lastOne, left, right);
            if (pos == k - 1) {
                break;
            } else if (pos < k - 1) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }

        return Arrays.copyOf(order, k);
    }

    private int quickSelect(int[] order, int[] array, int left, int right) {
        int pivotIndex = left;
        int pivot = array[order[left]];

        // array[left] >= pivot >= array[right]
        while (left <= right) {
            while (left <= right && (array[order[left]] < pivot || (array[order[left]] == pivot && order[left] <= order[pivotIndex]))) left++;
            while (left <= right && (array[order[right]] > pivot || array[order[right]] == pivot && order[right] >= order[pivotIndex])) right--;
            if (left < right) {
                swap(order, left, right);
            }
        }
        swap(order, right, pivotIndex);

        return right;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private int lastOne(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }// exit condition left == right

        return array[left] == 1 ? left : left - 1;
    }

    public static void main(String[] args) {
        TheKWeakestRowsinaMatrix theKWeakestRowsinaMatrix = new TheKWeakestRowsinaMatrix();
//        int[][] soilders = new int[][]{
//                {1,1,0,0,0},
//                {1,1,1,1,0},
//                {1,0,0,0,0},
//                {1,1,0,0,0},
//                {1,1,1,1,1}};
//        int k = 3;
        int[][] soilders = new int[][]{
                {1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
                {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        int k = 17;

        theKWeakestRowsinaMatrix.kWeakestRows(soilders, k);
    }
}
