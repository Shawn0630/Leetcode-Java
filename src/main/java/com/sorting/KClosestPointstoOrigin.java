package com.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // 1 2 3 4, k = 3 => 3
        // queue size 3 min
        // 1 => 1 2 => 1 2 3 => (1) 2 3 4

        // queue size 3 max
        // 1 => 2 1 => 3 2 1 => (4) 3 2 1

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> distance(b[0], b[1]) - distance(a[0], a[1]));

        for(int[] point : points) {
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] ans = new int[k][2];
        int idx = 0;
        while (!queue.isEmpty()) {
            ans[idx++] = queue.poll();
        }

        return ans;
    }

    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> distance(a[0], a[1]) - distance(b[0], b[1]));

        return Arrays.copyOf(points, k);
    }

    public int[][] kClosest3(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (true) {
            // Repeatedly partition the array
            // while narrowing in on the kth element
            pivotIndex = partition(points, left, right); //[0...pivotIndex] smaller/equals than a num, [pivotIndex + 1, length - 1] greater/equals than a num
            if (pivotIndex == k - 1) {
                return Arrays.copyOf(points, k);
            }
            if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }


    // find the correct pos for pivot
    private int partition(int[][] points, int left, int right) {
        int pivotIndex = left;
        int[] pivot = points[left];
        int pivotDist = distance(pivot[0], pivot[1]);

        while (left <= right) {
           while(left <= right && distance(points[left][0], points[left][1]) <= pivotDist) {
               left++;
           }
           // arr[left] > arr[pivotIndex]
           while (left <= right && distance(points[right][0], points[right][1]) >= pivotDist) {
               right--;
           }
           // arr[right] < arr[pivotIndex]
           if(left < right) {
               swap(points, left, right);
           }
           // arr[right] > arr[pivotIndex]
        }
        // left > right
        swap(points, right, pivotIndex); // arr[right] < arr[pivotIndex]

        // array[left] >= pivot
        return right;
    }

    private void swap(int[][] points, int i, int j) {
        if (i < 0 || i >= points.length || j < 0 || j >= points.length) {
            return;
        }

        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int distance(int x, int y) {
        return x * x + y * y;
    }
}
