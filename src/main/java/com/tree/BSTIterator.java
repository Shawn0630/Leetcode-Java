package com.tree;

import java.util.Stack;

public class BSTIterator {
    // https://leetcode.com/problems/binary-search-tree-iterator/discuss/1222327/Simple-Solution-using-Stack
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.peek() != null) {
            TreeNode top = stack.pop();

            TreeNode cur = top.right;
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            return top.val;
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
