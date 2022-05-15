package com.tree.binary_search_tree;

import com.tree.TreeNode;

import java.util.Stack;

public class InsertintoaBinarySearchTree {
    //      4,2,7,1,3
    //          4
    //      2          7
    //  1       3   6

    // add 5

    //              4
    //        2            7
    //                  6
    //               5
    // assumptions/constraints
    // 1. value is unique
    // 2. root can be a null

    //          3
    //      1       6
    //
    //          3
    //      1       6
    //         2
    //
    // add 2

    //          2
    //              3
    //          5       6
    // simulation
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while(true) {
            if(cur.val <= val) {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
