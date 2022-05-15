package com.tree;

public class ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return bstFromPreorder(preorder, 0, preorder.length);
    }

    public TreeNode bstFromPreorder(int[] preorder, int left, int right) { // [ )
        if (left >= right) {
            return null;
        }

        int cur = preorder[left];
        TreeNode root = new TreeNode(cur);
        int i = left + 1;
        while(i < right && preorder[i] < cur) i++; // i = right or preorder[i] > cur
        root.left = bstFromPreorder(preorder, left + 1, i);
        root.right = bstFromPreorder(preorder, i, right);

        return root;
    }

    // [8,5,1,7,10,12]
    //          8
    //      5           10
    //  1       7           12
    public TreeNode bstFromPreorder2(int[] preorder) {
        return bstFromPreorder2(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder2(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int rightSubtreeIndex = start + 1;
        while (rightSubtreeIndex <= end && preorder[start] > preorder[rightSubtreeIndex]) rightSubtreeIndex++;
        root.left = bstFromPreorder2(preorder, start + 1, rightSubtreeIndex - 1);
        root.right = bstFromPreorder2(preorder, rightSubtreeIndex, end);
        return root;
    }
}
