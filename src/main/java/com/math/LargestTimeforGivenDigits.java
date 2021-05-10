package com.math;

import java.util.Arrays;

public class LargestTimeforGivenDigits {
    private int max;

    public String largestTimeFromDigits(int[] arr) {
       max = Integer.MIN_VALUE;

       Arrays.sort(arr);

       permutate(arr, new int[arr.length], new boolean[arr.length], 0);

       if (max == Integer.MIN_VALUE) {
           return "";
       }
       int hour = max / 60;
       int min = max % 60;

       return (hour < 10 ? "0" + hour : hour) + ":" + (min < 10 ? "0" + min : min);
    }

    private void permutate(int[] arr, int start) {
        if (start == arr.length) {
            buildTime(arr);
        }

        for (int i = start; i < arr.length; i++) {
            swapArray(arr, i, start);
            permutate(arr, start + 1);
            swapArray(arr, i, start);
        }
    }

    private void permutate(int[] array, int[] res, boolean[] flag, int cur) {
        if(cur == array.length) {
            buildTime(res);
        } else {
            for(int i = 0; i < array.length; i++) {
                if (flag[i] || (i > 0 && array[i -1] == array[i] && !flag[i - 1])) {
                    continue;
                }
                res[cur] = array[i];
                flag[i] = true;
                permutate(array, res, flag, cur + 1);
                flag[i] = false;
            }
        }
    }

    private void buildTime(int[] arr) {
        int hour = arr[0] * 10 + arr[1];
        int minute = arr[2] * 10 + arr[3];

        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
            max = Math.max(max, hour * 60 + minute);
        }
    }

    private void swapArray(int[] array, int source, int destination) {
        if (source != destination) {
            int temp = array[source];
            array[source] = array[destination];
            array[destination] = temp;
        }
    }


}
