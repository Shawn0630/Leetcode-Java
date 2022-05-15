package com.segement_tree;


public class MyCalendar {
    // https://leetcode.com/problems/my-calendar-i/discuss/765039/Java-Binary-Search-Tree-Straightforward
    SegmentTreeNode root;
    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new SegmentTreeNode(start, end, true);
            return true;
        } else {
            return insert(root, start, end);
        }
    }


    private boolean insert(SegmentTreeNode root, int start, int end) {
        if (start >= end) {
            return false;
        }
        if (end <= root.start) {
            if (root.left == null) {
                root.left = new SegmentTreeNode(start, end, true);
                return true;
            } else {
                return insert(root.left, start, end);
            }
        } else if (start >= root.end) {
            if (root.right == null) {
                root.right = new SegmentTreeNode(start, end, true);
                return true;
            } else {
                return insert(root.right, start, end);
            }
        }

        return false;
    }

    private class SegmentTreeNode {
        public SegmentTreeNode left, right;
        public int start, end;
        public boolean occupied;

        public SegmentTreeNode(int start, int end, boolean occupied) {
            this.start = start;
            this.end = end;
            this.occupied = occupied;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
