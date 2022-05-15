package com.tree.balance_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    // assumptions/constraints
    // 1. root can be null
    //

    //                  1
    //          2           3
    //      4       5 -> 6       7
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/515985/Python-3-approaches-Clean-and-Concise
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            while (size > 0) {
                list.add(queue.poll());
                size--;
            }


            Node prev = null;
            for(int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if (i == 0) {
                    prev = node;
                } else {
                    prev.next = node;
                    prev = node;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
        }


        return root;
    }

    //Intuitive:
    //1. use left child to move current to the next level
    //2. make use of next pointer from the previous level
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37500/Hint-for-O(1)-space
    public Node connect2(Node root) {

        Node leftmost = root;

        while (leftmost != null) {

            Node cur = leftmost;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }

            leftmost = leftmost.left;
        }


        return root;
    }

    public Node connect3(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Node> cur = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                cur.add(queue.poll());
                size--;
            }

            for(int i = 0; i < cur.size(); i++) {
                Node node = cur.get(i);
                if (i + 1 < cur.size()) {
                    node.next = cur.get(i + 1);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/172861/Mostly-recursive-solution-O(n)-time-(beats-99.32)-and-O(1)-space-(without-considering-stack)

    //           1
    //       2   ->   3
    //   4               -> 6

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
