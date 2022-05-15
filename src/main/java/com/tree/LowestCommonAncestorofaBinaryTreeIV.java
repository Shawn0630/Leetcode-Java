package com.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorofaBinaryTreeIV {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> ids = new HashSet<>();

        for (TreeNode node : nodes) {
            ids.add(node.val);
        }

        return lowestCommonAncestor(root, ids);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, Set<Integer> ids) {
        if (root == null) {
            return null;
        }

        int id = root.val;
        if (ids.contains(id)) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, ids);
            TreeNode right = lowestCommonAncestor(root.right, ids);

            if (left != null && right != null) {
                return root;
            } else { // left == null || right == null
                return left == null ? right : left;
            }
        }
    }


}
