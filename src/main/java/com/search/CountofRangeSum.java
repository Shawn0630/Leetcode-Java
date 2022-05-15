package com.search;

public class CountofRangeSum {
    // https://leetcode.com/problems/count-of-range-sum/discuss/1178174/Java-Clean-Merge-Sort-O(N-logN)-Solution-oror-with-detailed-Explanation
    private int count;
    private int lower;
    private int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        this.count = 0;

        build(nums);

        return count;
    }

    private SegmentTreeNode build(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return build(arr, 0, arr.length - 1);
    }

    private SegmentTreeNode build(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = arr[start];
            return root;
        }

        int mid = (start + end) >> 1;
        root.left = build(arr, start, mid);
        root.right = build(arr, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    private static class SegmentTreeNode {
        public int start, end;
        public long sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }
}
