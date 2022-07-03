package com.tree;

public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) {
            return null;
        } // original != null && cloned != null

        if (original.val != cloned.val) {
            return null;
        }

        if (cloned.val == target.val) {
            return cloned;
        } else {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            TreeNode right = getTargetCopy(original.right, cloned.right, target);

            return left == null ? right : left;
        }
    }
}
