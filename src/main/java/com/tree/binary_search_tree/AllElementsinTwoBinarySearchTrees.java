package com.tree.binary_search_tree;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        TreeIterator it1 = new TreeIterator(root1);
        TreeIterator it2 = new TreeIterator(root2);

        List<Integer> ans = new ArrayList<>();

        while (it1.hasNext() && it2.hasNext()) {
            int a = it1.peek().val;
            int b = it2.peek().val;

            if (a < b) {
                ans.add(it1.getNext().val);
            } else {
                ans.add(it2.getNext().val);
            }
        }

        while (it1.hasNext()) {
            ans.add(it1.getNext().val);
        }
        while (it2.hasNext()) {
            ans.add(it2.getNext().val);
        }
        return ans;
    }


    private static class TreeIterator {

        TreeNode cur;
        Stack<TreeNode> stack;
        TreeIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        TreeNode peek() {
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    return stack.peek();
                }
            }

            return null;
        }

        TreeNode getNext() {
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode returnNode = stack.pop();
                    cur = returnNode.right;

                    return returnNode;
                }
            }

            return null;
        }

        boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
