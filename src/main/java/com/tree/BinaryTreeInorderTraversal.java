package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        inorderTraversal(root, output);

        return output;
    }

    private void inorderTraversal(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, output);
        output.add(root.val);
        inorderTraversal(root.right, output);
    }
}
