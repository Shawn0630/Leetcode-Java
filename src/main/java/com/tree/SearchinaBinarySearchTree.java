package com.tree;

public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        int cur = root.val;
        if (cur == val) {
            return root;
        } else if (val < cur) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
