package com.tree;

public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        } else if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
