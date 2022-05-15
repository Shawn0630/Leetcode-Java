package com.tree;

public class LowestCommonAncestorofDeepestLeaves {
    // 0,1,3,null,2
    /*
    *         0
    *      1      3
    *  null 2
    *
    * */

    // https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return getlcaDFS(root, 0).root;
    }

    private Node getlcaDFS(TreeNode root, int height) {
        if (root == null) {
            return new Node(null, height);
        }

        Node left = getlcaDFS(root.left, height + 1);
        Node right = getlcaDFS(root.right, height + 1);
        if (left.height == right.height) {
            return new Node(root, left.height);
        } else {
            return left.height > right.height ? left : right;
        }
    }


    private class Node {
        TreeNode root;
        int height;

        public Node(TreeNode root, int height) {
            this.root = root;
            this.height = height;
        }
    }
}
