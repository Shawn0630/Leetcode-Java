package com.tree;

import java.util.Arrays;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    //              r                                   r
    //          3
    //      9       20
    //          15      7
    //


    //              1
    //      2               3
    //  4       5       6        7

    //  4   2   5   1   6   3   7


    // [2,3,1]
    // [3,2,1]

    //          1
    //     2
    //          3
    //
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0,postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) return null;

        int rootValue = postorder[pe];
        int inOrderRootIndex = findFirst(inorder, rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(inorder, is, inOrderRootIndex - 1, postorder, ps, ps + inOrderRootIndex - is - 1);
        root.right = buildTree(inorder, inOrderRootIndex + 1, ie, postorder, pe - (ie - inOrderRootIndex), pe - 1);

        return root;
    }

    private int findFirst(int[] inorder, int value) {
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ConstructBinaryTreefromInorderandPostorderTraversal constructBinaryTreefromInorderandPostorderTraversal = new ConstructBinaryTreefromInorderandPostorderTraversal();
        constructBinaryTreefromInorderandPostorderTraversal.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

    }
}
