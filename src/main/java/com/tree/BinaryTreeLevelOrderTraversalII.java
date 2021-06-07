package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int n = queue.size();
            while (n > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    curLevel.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                n--;
            }
            ans.add(0, curLevel);
        }

        return ans;
    }
}
