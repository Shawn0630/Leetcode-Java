package com.dynamic_programming;

import com.tree.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        return Math.max(rob(root, true), rob(root, false));
    }

    private int rob(TreeNode root, boolean picked) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (picked) {
                return root.val;
            } else {
                return 0;
            }
        }

        int leftNotPicked = rob(root.left, false);
        int leftPicked = rob(root.left, true);
        int rightNotPicked = rob(root.right, false);
        int rightPicked = rob(root.right, true);

        if (picked) {
            return root.val + leftNotPicked + rightNotPicked;
        } else {
            return Math.max(leftNotPicked + rightNotPicked, Math.max(leftNotPicked + rightPicked, Math.max(leftPicked + rightNotPicked, leftPicked + rightPicked)));
        }

    }
}
