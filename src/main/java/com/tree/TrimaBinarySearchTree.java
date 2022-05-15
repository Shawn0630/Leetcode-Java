package com.tree;

public class TrimaBinarySearchTree {

    //      1
    //  2       3

    // [3,0,4,null,2,null,null,1]
    //1
    //3

    //              3
    //      0                   4
    //          2
    //       1
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }


        return root;

    }
}
