package com.tree;

import java.util.ArrayList;
import java.util.List;

public class CloneNAryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public Node cloneTree(Node root) {

        return null;
    }
}
