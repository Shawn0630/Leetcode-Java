package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIteratorII {

    Stack<TreeNode> next;
    List<TreeNode> list;
    int pointer;
    TreeNode cur;
    public BinarySearchTreeIteratorII(TreeNode root) {
        this.cur = root;
        next = new Stack<>();
        list = new ArrayList<>();
        pointer = -1;
    }

    public boolean hasNext() {
        return cur != null || !next.empty() || pointer < list.size() - 1;
    }

    public int next() {
        ++pointer;
        if (pointer == list.size()) {
            while (cur != null || !next.empty()) {
                if (cur != null) {
                    next.push(cur);
                    cur = cur.left;
                } else { //cur == null
                    TreeNode returnedNode = next.pop();
                    list.add(returnedNode);
                    cur = returnedNode.right;

                }
            }
        }

        return list.get(pointer).val;
    }

    public boolean hasPrev() {
        return pointer >= 1;
    }

    public int prev() {
        int value = list.get(pointer - 1).val;
        pointer--;
        return value;
    }
}
