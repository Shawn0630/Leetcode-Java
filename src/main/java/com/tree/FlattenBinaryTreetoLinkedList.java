package com.tree;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        flattenDFS(root);
    }

    private TreeNode flattenDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        // is leaf
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = flattenDFS(root.left);
        TreeNode right = flattenDFS(root.right);

        if (left != null) {
            left.left = null;
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right == null ? left : right;
    }
}
