package com.tree;

public class DeepestLeavesSum {

    // [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    //                      6
    //          7                       8
    //      2(9)        7(5)        1              3 5
    //  9      null   1     4   null    null   null     5
    public int deepestLeavesSum(TreeNode root) {
        int[] ans = deepestLeaveSumDFS(root, 0);

        return ans[0];
    }

    private int[] deepestLeaveSumDFS(TreeNode root, int height) {
        if (root == null) {
            return null;
        }
        int[] left = deepestLeaveSumDFS(root.left, height + 1);
        int[] right = deepestLeaveSumDFS(root.right, height + 1);
        if (left == null && right == null) {
            return new int[]{root.val, height};
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return left[1] == right[1] ? new int[]{left[0] + right[0], left[1]} : left[1] < right[1] ? right : left;
        }
    }
}
