package com.array;

import org.algorithm_visualizer.Array1DTracer;
import org.algorithm_visualizer.Commander;
import org.algorithm_visualizer.Layout;
import org.algorithm_visualizer.Tracer;
import org.algorithm_visualizer.VerticalLayout;


// 1000 2000 1 3000 => 1 xxx xxx xxx
// 2 1 4 3 => 1 2 3 4
public class FirstMissingPositive {
    private static final Array1DTracer numsTracer = new Array1DTracer("nums");
    public static int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (correctIndex < nums.length && correctIndex >= 0 && nums[correctIndex] != nums[i]) {
                swap(nums, i, correctIndex);
                numsTracer.set(nums);
                Tracer.delay();
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }

    static void swap(int[] ar, int first, int second) {
        int temp = ar[first];
        ar[first] = ar[second];
        ar[second] = temp;
    }

    public static void main(String[] args) {
        Layout.setRoot(new VerticalLayout(new Commander[]{numsTracer}));
//        int[] array = new int[]{2, 1, 4, 3};
        int[] array = new int[]{1, 1};
        firstMissingPositive(array);
        numsTracer.set(array);
    }


}
