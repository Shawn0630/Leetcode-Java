package com.tree;

public class SumRoottoLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumDFS(root, 0);
        return sum;
    }

    private void sumDFS(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        int val = root.val;
        cur = cur * 10 + val;
        if (root.left == null && root.right == null) {
            sum += cur;
        }

        if (root.left != null) {
            sumDFS(root.left, cur);
        }
        if (root.right != null) {
            sumDFS(root.right, cur);
        }
    }
}
