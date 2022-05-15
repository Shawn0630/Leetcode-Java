package com.segement_tree;

// https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/
public class RangeSumQueryMutable {
    int[] segmentTree;
    int n;


    // 3 elements
    // 2 * 3 = 6
    // [0,1,2,3,4,5]
    //              1
    //      2               3
    //  4       5
    public RangeSumQueryMutable(int[] nums) {
        segmentTree = new int[2 * nums.length];
        n = nums.length;
        buildSegmentTree(segmentTree, nums);
    }

    public void update(int index, int val) {
        int p = index + n;
        segmentTree[p] = val;

        while (p > 0) { // leaf to root
            int l = p;
            int r = p;
            if ((l % 2) == 1) {
                l--;// find its left neighbour
            }
            if ((r % 2) == 0) {
                r++; // find its right neighbour
            }
            segmentTree[p / 2] = segmentTree[l] + segmentTree[r];
            p /= 2;
        }

    }

    // l≤r and sum of [L…l] and [r…R] has been calculated
    public int sumRange(int left, int right) {
        int l = left + n;
        int r = right + n;

        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) { // l % 2 == 0
                sum += segmentTree[l];
                l++; // to the pointer to right of its parents
            }
            if ((r % 2) == 0) { // r % 2 == 1
                sum += segmentTree[r];
                r--; // to the pointer to left of its parents
            }

            l /= 2;
            r /= 2;
        }

        return sum;
    }

    private void buildSegmentTree(int[] tree, int[] nums) {
        for(int i = nums.length, j = 0; i < 2 * nums.length; i++, j++) {
            segmentTree[i] = nums[j];
        }

        for(int i = nums.length - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }
}
