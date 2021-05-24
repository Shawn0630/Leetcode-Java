package com.tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/1210747/Easy-to-Understand-Indexing-(Java)
    int pre_order_index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null ||
                preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder,
                               int left_in_order, int right_in_order) {
        if (pre_order_index >= preorder.length || left_in_order > right_in_order) {
            return null;
        }
        int root = preorder[pre_order_index++];
        int index;
        for (index = left_in_order; index <= right_in_order; index++) {
            if (inorder[index] == root) break;
        }

        TreeNode rootNode = new TreeNode(root);
        TreeNode leftNode = buildTree(preorder, inorder, left_in_order, index - 1);
        TreeNode rightNode = buildTree(preorder, inorder, index + 1, right_in_order);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }
}
