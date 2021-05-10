package com.sliding_window;

public class LongestMountaininArray {
    public int longestMountain(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int i = 0;
        int ans = 0;

        while (i < arr.length) {
            int left = i;
            int top;
            while (i < arr.length - 1 && arr[i + 1] > arr[i]) i++;
            if (left == i) {
                i++;
                continue;
            } else {
                top = i;
            }
            while (i < arr.length - 1 && arr[i + 1] < arr[i]) i++;
            if (top != i) {
                ans = Math.max(ans, i - left + 1);
            } else {
                i++;
            }
        }

        return ans;
    }
}
