package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    // https://www.1point3acres.com/bbs/thread-863772-1-1.html
    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/883704/Python-2-solutions%3A-DFS-BFS-O(N)-Clean-and-Concise
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("#");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    sb.append(node.left.val);
                } else {
                    sb.append("null");
                }
                sb.append(",");
                if (node.right != null) {
                    sb.append(node.right.val);
                } else {
                    sb.append("null");
                }
                sb.append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("#");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] levels = data.split("#");

        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(levels[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int idx = 1;
        while (idx < levels.length && !queue.isEmpty()) {
            TreeNode parent = queue.poll();
            String[] children = levels[idx].split(",");
            if (children[0].equals("null")) {
                parent.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(children[0]));
                parent.left = left;
                queue.offer(left);
            }

            if (children[1].equals("null")) {
                parent.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(children[1]));
                parent.right = right;
                queue.offer(right);
            }

            idx++;
        }

        return root;
    }

//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "#";
//        }
//        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
//
//    }

//    int i;
//    public TreeNode deserialize(String data) {
//        String[] nodes = data.split(",");
//        i = 0;
//        return dfs(nodes);
//    }
//
//    private TreeNode dfs(String[] nodes) {
//        if (i >= nodes.length) {
//            return null;
//        }
//
//        String rootVal = nodes[i++];
//
//        if (rootVal.equals("#")) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
//        root.left = dfs(nodes);
//        root.right = dfs(nodes);
//
//        return root;
//    }

//    public String serialize(TreeNode root) {
//        List<String> ans = new ArrayList<>();
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                ans.add("#");
//            } else {
//                ans.add(String.valueOf(node.val));
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }
//        }
//
//        return String.join(",", ans);
//    }
//
//    public TreeNode deserialize(String data) {
//        return null;
//    }

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree serializeandDeserializeBinaryTree = new SerializeandDeserializeBinaryTree();
        String serialized = serializeandDeserializeBinaryTree.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        //String serialized = "1,2,3,#,#,4,#,#,5,#,#";
        TreeNode root = serializeandDeserializeBinaryTree.deserialize(serialized);
        System.out.println(root);
    }
}
