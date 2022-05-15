package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeNAryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(root.val);
        sb.append(",null");

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node cur = queue.poll();

                List<Node> children = cur.children;
                for (Node child : children) {
                    sb.append(",").append(child.val);
                    queue.add(child);
                }
                sb.append(",null");
                size--;
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // level order
    public Node deserialize(String data) {
        String input = data.substring(1, data.length() - 1);
        if (input.isEmpty()) return null;
        String[] elements = input.split(",");
        Queue<Node> queue = new LinkedList<>();
        Node cur = null;
        Node root = null;

        for(String element : elements) {
            if (element.equals("null")) {
                if (!queue.isEmpty()) {
                    cur = queue.poll();
                }
            } else {
                Node node = new Node(Integer.parseInt(element), new ArrayList<>());
                if (cur == null) {
                    cur = node;
                    root = node;
                } else {
                    cur.children.add(node);
                }
                queue.offer(node);
            }
        }

        return root;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String args[]) {
        SerializeandDeserializeNAryTree serializeandDeserializeNAryTree = new SerializeandDeserializeNAryTree();
//        Node root = serializeandDeserializeNAryTree.deserialize("[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]");
//        //Node root = serializeandDeserializeNAryTree.deserialize("[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14,null,null,null,null]");
//        String data = serializeandDeserializeNAryTree.serialize(root);
//        Node root2 = serializeandDeserializeNAryTree.deserialize(data);
        serializeandDeserializeNAryTree.deserialize("[]");
    }
}
