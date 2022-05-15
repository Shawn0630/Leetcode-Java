package com.tree;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandomPointer {
    public class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }


    // [[1,null],null,[4,3],[7,0]]
    //              1
    //      null        4
    //
    Map<Node, NodeCopy> map;
    public NodeCopy copyRandomBinaryTree(Node root) {
        map = new HashMap<>();

        return copyRandomBinaryTreeDFS(root);
    }

    private NodeCopy copyRandomBinaryTreeDFS(Node root) {
        if (root == null) {
            return null;
        }

        NodeCopy newNode = map.getOrDefault(root, new NodeCopy(root.val));
        map.put(root, newNode);

        newNode.left = copyRandomBinaryTreeDFS(root.left);
        newNode.right = copyRandomBinaryTreeDFS(root.right);

        if (root.random != null) {
            map.putIfAbsent(root.random, new NodeCopy(root.random.val));
            newNode.random = map.get(root.random);
        }

        return newNode;
    }
}
