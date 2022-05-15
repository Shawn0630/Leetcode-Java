package com.tree;

public class SumofLeftLeaves {
    int leftSum;
    public int sumOfLeftLeaves(TreeNode root) {
        leftSum = 0;

        sumOfLeftLeavesRecursive(root, false);

        return leftSum;
    }

    private void sumOfLeftLeavesRecursive(TreeNode root, boolean isLeftChild) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && isLeftChild) {
            leftSum += root.val;
            return;
        }
        sumOfLeftLeavesRecursive(root.left, true);
        sumOfLeftLeavesRecursive(root.right, false);
    }
}
