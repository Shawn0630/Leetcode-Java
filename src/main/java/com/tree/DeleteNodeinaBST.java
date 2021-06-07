package com.tree;

public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        int val = root.val;
        if (val > key) {
            root.left = deleteNode(root.left, key);
        } else if (val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            // has left node only
            else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                // use root.left
                TreeNode rightmostLeafAtLeftSubTree = root.left;
                while (rightmostLeafAtLeftSubTree.right != null) {
                    rightmostLeafAtLeftSubTree = rightmostLeafAtLeftSubTree.right;
                }
                rightmostLeafAtLeftSubTree.right = root.right;

                return root.left;
            }
        }
        return root;
    }
}
