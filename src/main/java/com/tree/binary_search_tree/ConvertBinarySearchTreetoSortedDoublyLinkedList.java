package com.tree.binary_search_tree;

import java.util.Stack;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    // assumption/constraint:
    // 1. null node
    // intuition:


    //              4(1,3->4->5)
    //      2(1,3)             5(5,5)
    // 1        3

    //          2
    //  1(1,1)

    //https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/discuss/149647/Recursive-and-Iterative-Inorder-traversal-with-a-dummyHead
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        ReturnNode node = treeToDoublyListDFS(root);
        node.tail.right = node.head;
        node.head.left = node.tail;
        return node.head;
    }

    //          a
    //   b              c

    //   b  -> a  -> c
    public Node treeToDoublyList3(Node root) {
        Node cur = root;
        Node dummy = new Node(-1, null, null);
        Node prev = dummy;
        Stack<Node> stack = new Stack<>();

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else { // !stack.empty()
                cur = stack.pop();
                connect(prev, cur);

                prev = cur;
                cur = cur.right;
            }
        }

        connect2(prev, dummy.right);
        return dummy.right;
    }

    private void connect2(Node prev, Node cur) {
        prev.right = cur; // a -> b
        cur.left = prev; // a <- b
    }

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();

        Node cur = root;
        Node dummy = new Node(0);
        Node prev = dummy;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                connect(prev, cur);
                prev = cur;
                cur = cur.right;
            }
        }

        Node head = dummy.right;
        connect(prev, head);

        return head;
    }

    private void connect(Node left, Node right) {
        left.right = right;
        right.left = left;
    }

    private ReturnNode treeToDoublyListDFS(Node root) {
        if (root == null) {
            return null;
        }

        ReturnNode leftNode = treeToDoublyListDFS(root.left);//1,1
        ReturnNode rightNode = treeToDoublyListDFS(root.right);//null
        Node head, tail;

        if (leftNode != null) {
            head = leftNode.head;//1
            leftNode.tail.right = root;//1->2
            root.left = leftNode.tail;//2<-1
        } else {
            head = root;
        }
        if (rightNode != null) {
            tail = rightNode.tail;
            root.right = rightNode.head;
            rightNode.head.left = root;
        } else {
            tail = root;//2
        }

        return new ReturnNode(head, tail); // 1, 2
    }

    private class ReturnNode {
        Node head;
        Node tail;

        ReturnNode(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        ConvertBinarySearchTreetoSortedDoublyLinkedList convertBinarySearchTreetoSortedDoublyLinkedList = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
        convertBinarySearchTreetoSortedDoublyLinkedList.treeToDoublyList(new Node(2, new Node(1), null));
    }
}
