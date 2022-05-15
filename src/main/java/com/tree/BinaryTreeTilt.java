package com.tree;

public class BinaryTreeTilt {
    // [4,2,9,3,5,null,7]

    /**
     *        4
     *      /   \
     *     2     9
     *    / \     \
     *   3   5     7
     *
     *   leftSum = 10
     *   rightSum = 16
     * */

    int ans = 0;
    public int findTilt(TreeNode root) {
        sum(root);

        return ans;
    }

    private int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        ans += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
