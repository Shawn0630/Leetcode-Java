package com.tree;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) {
            return null;
        }

        int rootIndex = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(nums, start, rootIndex - 1);
        root.right = sortedArrayToBST(nums, rootIndex + 1, end);

        return root;
    }
}
