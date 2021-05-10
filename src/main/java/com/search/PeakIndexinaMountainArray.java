package com.search;

public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }

        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1; // mid ~ [0, arr.len - 2]

            if (mid > 0 && mid < arr.length - 1 && arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] < arr[mid]) { //if (A[mi] < A[mi + 1])
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return (lo > 0 && lo < arr.length - 1 && arr[lo - 1] < arr[lo] && arr[lo] > arr[lo + 1]) ? lo : -1;
    }
}
