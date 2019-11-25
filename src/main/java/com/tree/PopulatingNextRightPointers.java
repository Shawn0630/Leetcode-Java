package com.tree;

public class PopulatingNextRightPointers {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return root;
        helper(root.left, root.right);
        return root;
    }
    private void helper(Node root1, Node root2) {
        if(root1 == null || root2 == null) return ;
        root1.next = root2;
        helper(root1.left, root1.right);
        helper(root1.right, root2.left);
        helper(root2.left, root2.right);
    }

    public Node connect2(Node root) {
        if (root == null) return root;
        helper2(root.left, root.right);

        return root;
    }

    private void helper2(Node root1, Node root2) {
        if (root1 == null || root2 == null) return;

        root1.next = root2;

        Node[] nodes = new Node[]{root1.left, root1.right, root2.left, root2.right};
        int cur = 0, nxt = 1;
        while (nxt < nodes.length) {
            if (nodes[cur] != null && nodes[nxt] != null) {
                helper2(nodes[cur], nodes[nxt]);
                cur = nxt;
                nxt = cur + 1;
            } else if (nodes[cur] == null) {
                cur = cur + 1;
                nxt = cur + 1;
            } else if (nodes[nxt] == null) {
                nxt = nxt + 1;
            }
        }
    }
}
