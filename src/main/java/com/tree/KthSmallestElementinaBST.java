package com.tree;

import java.util.Stack;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
           while (cur != null) {
               stack.add(cur);
               cur = cur.left;
           }
           if (stack.peek() != null) {
               TreeNode node = stack.pop();
               k--;
               if (k == 0) {
                   return node.val;
               }
               cur = node.right;
           }
        }
    }
}
