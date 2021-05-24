package com.tree;

public class ValidateBinarySearchTree {
    // https://leetcode.com/problems/validate-binary-search-tree/discuss/1150778/Java-solution-both-recursive-and-non-recursive-good-way-to-build-concept-on-Tree
    // [5,4,6,null,null,3,7]
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null && left.val >= val) {
            return false;
        }
        if (right != null && right.val <= val) {
            return false;
        }

        return isValidBST(left) && isValidBST(right);
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        if (val <= lower || val >= upper) {
            return false;
        }

        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
    }

}
