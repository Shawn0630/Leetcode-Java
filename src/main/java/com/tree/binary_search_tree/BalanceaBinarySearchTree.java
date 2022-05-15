package com.tree.binary_search_tree;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {
    List<TreeNode> order;
    public TreeNode balanceBST(TreeNode root) {
        order = new ArrayList<>();
        inorderTraversal(root);
        return balanceBST(order, 0, order.size() - 1);
    }


    //              1
    //    2                   3
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        order.add(root);
        inorderTraversal(root.right);
    }

    private TreeNode balanceBST(List<TreeNode> order, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = order.get(mid);
        root.left = balanceBST(order, left, mid - 1);
        root.right = balanceBST(order, mid + 1, right);

        return root;
    }
}
