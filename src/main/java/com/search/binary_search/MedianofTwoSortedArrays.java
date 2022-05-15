package com.search.binary_search;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = 0, r1 = nums1.length - 1;
        int l2 = 0, r2 = nums2.length - 1;

        return 0.0;
    }

    //  0       1
    // [1,      3],
    //  l       r
    //  m
    //

    //
    // [2]
    //  lr
    //  m
    private double findMedianSortedArrays(int[] nums1, int[] nums2, int l1, int r1, int l2, int r2) {
        int mid1 = l1 + (r1 - l1) / 2;
        int mid2 = l2 + (r2 - l2) / 2;

        return 0.0;
    }
}
