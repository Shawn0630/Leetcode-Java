package com.tree;

import java.util.Stack;

public class RecoverBinarySearchTree {
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    // refering to https://leetcode.com/problems/recover-binary-search-tree/discuss/32562/Share-my-solutions-and-detailed-explanation-with-recursiveiterative-in-order-traversal-and-Morris-traversal
    // converting recursive dfs to iterative dfs: https://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
    public void recoverTree(TreeNode root) {

        inOrder(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (prev != null && prev.val >= node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        inOrder(node.right);
    }


    private void recoverTree2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;

        TreeNode cur = node;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()) {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = cur;
                }

                pre = cur;

                cur = cur.right;
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
