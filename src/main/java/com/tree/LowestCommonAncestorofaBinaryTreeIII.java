package com.tree;

public class LowestCommonAncestorofaBinaryTreeIII {


    /**
     *       0
     *   1       2
     *  3  7   4   5
     *    8   6
     *  3 6  => 0
     *  3 8  => 1
     * */

    //          0(2)
    //      1(null)       2 (2)
    //           3(3)      4 (5, 1)
    //                          5 (5, 0)
    // 3, 5 = > 2
    // 1, 3 => 0

    public Node lowestCommonAncestor(Node p, Node q) {
        Node pp = p;
        Node qq = q;
        int pHeight = 1;
        int qHeight = 1;
        while (pp != null) {
            pHeight++;
            pp = pp.parent;
        }
        while (qq != null) {
            qHeight++;
            qq = qq.parent;
        }

        Node aa, bb;
        int larger, smaller;
        if (pHeight >= qHeight) {
            aa = p;
            bb = q;
            larger = pHeight;
            smaller = qHeight;
        } else {
            aa = q;
            bb = p;
            larger = qHeight;
            smaller = pHeight;
        }

        while (larger != smaller) {
            aa = aa.parent;
            larger--;
        }

        while (aa != bb) {
            aa = aa.parent;
            bb = bb.parent;
        }

        return aa;
    }

    private class Node {
        int val;
        Node left, right, parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node lowestCommonAncestor2(Node p, Node q) {
        int pHeight = 0;
        int qHeight = 0;

        Node pCur = p;
        while (pCur != null) {
            pCur = pCur.parent;
            pHeight++;
        }
        Node qCur = q;
        while (qCur != null) {
            qCur = qCur.parent;
            qHeight++;
        }

        while (pHeight > qHeight && p != null) {
            p = p.parent;
            pHeight--;
        }// exit condition p == null || pHeight == qHeight
        while (qHeight > pHeight && q != null) {
            q = q.parent;
            qHeight--;
        }// exit condition p == null || pHeight == qHeight

        while (p != q && p != null && q != null) {
            p = p.parent;
            q = q.parent;
        }

        return p;

    }
}
