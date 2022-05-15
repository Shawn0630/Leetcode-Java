package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsinBinaryTree {
    // https://leetcode.com/problems/cousins-in-binary-tree/discuss/1527119/Java-BFS-concise-solution
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<Edge> queue = new LinkedList<>();
        if (root.left != null) {
            queue.add(new Edge(root, root.left));
        }
        if (root.right != null) {
            queue.add(new Edge(root, root.right));
        }

        while (!queue.isEmpty()) {
            List<Edge> edges = new ArrayList<>();
            while(!queue.isEmpty()) edges.add(queue.poll());
            TreeNode xParent = null, yParent = null;
            for (Edge edge : edges) {
                TreeNode parent = edge.parent;
                TreeNode child = edge.child;

                if (child.val == x) {
                    xParent = parent;
                }
                if (child.val == y) {
                    yParent = parent;
                }
                if(child.left != null) {
                    queue.add(new Edge(child, child.left));
                }
                if(child.right != null) {
                    queue.add(new Edge(child, child.right));
                }
            }
            if (xParent != null && yParent != null && xParent.val != yParent.val) {
                return true;
            }
        }

        return false;
    }

    private class Edge {
        TreeNode parent;
        TreeNode child;

        Edge(TreeNode parent, TreeNode child) {
            this.parent = parent;
            this.child = child;
        }
    }
}
