package com.sorting;

import org.algorithm_visualizer.Array1DTracer;
import org.algorithm_visualizer.Commander;
import org.algorithm_visualizer.Layout;
import org.algorithm_visualizer.Tracer;
import org.algorithm_visualizer.VerticalLayout;

public class PartitionVisualization {
    private static final Array1DTracer array1DTracer = new Array1DTracer("array");
    private static int partition(int[] array, int left, int right) {
        int pivotIndex = left;
        int pivot = array[left];

        while (left <= right) {
            while(left <= right && array[left] <= pivot) {
                left++;
            }
            array1DTracer.select(left);
            Tracer.delay();
            // arr[left] > arr[pivotIndex]
            while (left <= right && array[right] >= pivot) {
                right--;
            }
            array1DTracer.select(right);
            Tracer.delay();
            // arr[right] < arr[pivotIndex]
            if(left < right) {
                swap(array, left, right);
            }
            array1DTracer.set(array);
            Tracer.delay();
            array1DTracer.deselect(left);
            array1DTracer.deselect(right);
            // arr[right] > arr[pivotIndex]
        }
        // left > right
        array1DTracer.select(left);
        array1DTracer.select(pivotIndex);
        swap(array, right, pivotIndex); // arr[right] < arr[pivotIndex]
        array1DTracer.set(array);
        Tracer.delay();

        // array[left] >= pivot
        return right;
    }

    private static void swap(int[] points, int i, int j) {
        if (i < 0 || i >= points.length || j < 0 || j >= points.length) {
            return;
        }

        int temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        Layout.setRoot(new VerticalLayout(new Commander[]{array1DTracer}));
        int[] array = new int[]{5, 4, 3, 2, 1};
        array1DTracer.set(array);
        partition(array, 0, array.length - 1);
    }
}
