package com.tree.binary_search_tree;

import com.tree.TreeNode;

import java.util.Stack;

public class BSTIterator {

//    TreeNode root;
//    Stack<TreeNode> stack;
    // 7, 3, 15, null, null, 9, 20

    //                      7
    //              3               15
    //                        9             20
    //  3 -> 7 -> 9 -> 15 -> 20

    // 3 1 4 null 2

    //                  3
    //          1               4
    //              2
//    public BSTIterator(TreeNode root) {
//        this.root = root;
//        stack = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.left;
//        }
//    }

//    public int next() {
//        int returnedValue = -1;
//        if (hasNext()) {
//            TreeNode node = stack.pop();
//            returnedValue = node.val;
//            if (node.right != null) {
//                TreeNode cur = node.right;
//                while (cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                }
//            }
//        }
//        return returnedValue;
//    }

//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    TreeNode cur;
//    public BSTIterator(TreeNode root) {
//        this.cur = root;
//        stack = new Stack<>();
//
//    }
//
//    public int next2() {
//        while (cur != null || !stack.empty()) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                TreeNode returned = stack.pop();
//                cur = returned.right;
//                return returned.val;
//            }
//        }
//
//        return -1;
//    }
//
//    public boolean hasNext2() {
//        return cur != null || !stack.empty();
//    }

    TreeNode cur;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    public int next() {
       while (cur != null || !stack.empty()) {
           if (cur != null) {
               stack.push(cur);
               cur = cur.left;
           } else {
               TreeNode returned = stack.pop();
               cur = returned.right;
               return returned.val;
           }
       }

       return -1;
    }

    public boolean hasNext() {
        return cur == null && stack.empty();
    }
}
