package com.tree;


public class CountCompleteTreeNodes {
    // https://leetcode.com/problems/count-complete-tree-nodes/discuss/1537368/Java-or-0-ms-or-Explained
    public int countNodes(TreeNode root) {
        return (root == null) ?
                0 :
                1 + countNodes(root.left) + countNodes(root.right);
    }
}
