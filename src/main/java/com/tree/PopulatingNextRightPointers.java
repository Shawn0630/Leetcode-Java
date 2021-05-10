package com.tree;

import java.util.HashMap;
import java.util.Map;

public class PopulatingNextRightPointers {
    public TreeNodeWithNext connect(TreeNodeWithNext root) {
        if(root == null) return root;
        helper(root.left, root.right);
        return root;
    }
    private void helper(TreeNodeWithNext root1, TreeNodeWithNext root2) {
        if(root1 == null || root2 == null) return ;
        root1.next = root2;
        helper(root1.left, root1.right);
        helper(root1.right, root2.left);
        helper(root2.left, root2.right);
    }

    Map<Integer, TreeNodeWithNext> rightmost;
    public TreeNodeWithNext connect2(TreeNodeWithNext root) {
        if (root == null) return root;
        rightmost = new HashMap<>();
        helper2(root, 0);

        return root;
    }

    private void helper2(TreeNodeWithNext root, int level) {
        if (root == null ) return;

        if (root.right != null) {
            helper2(root.right, level + 1);
        }

        if (root.left != null) {
            helper2(root.left, level + 1);
        }

        if (rightmost.get(level) != null) {
            root.next = rightmost.get(level);
        }

        rightmost.put(level, root);
    }

//    public TreeNodeWithNext connect3(TreeNodeWithNext root) {
//        dfs(root);
//        return root;
//    }
//
//
//    private void dfs(TreeNodeWithNext node) {
//        if (node == null) {
//            return;
//        }
//
//        if (node.left != null) {
//            node.left.next = node.right;
//        }
//        if (node.right != null && node.next != null) {
//            node.right.next = node.next.left;
//        }
//
//        dfs(node.left);
//        dfs(node.right);
//    }
}
