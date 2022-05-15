package com.tree.balance_tree;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int left = 0, right = list.size();
        return constructBST(left, right);
    }

    private TreeNode constructBST(int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = list.get(mid);
        root.left = constructBST(left, mid - 1);
        root.right = constructBST(mid + 1, right);

        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
