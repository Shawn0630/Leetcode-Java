package com.tree;

public class FindDistanceinaBinaryTree {
    // [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
    //                  3
    //      5                       1
    //  6       2               0        8
    //      7       4


    // 7    4       => not in a subtree
    // 5    7       => subtree

    // https://leetcode.com/problems/find-distance-in-a-binary-tree/discuss/1039737/Detailed-explanation-of-how-to-solve-in-ONE-pass-based-on-LCA-approach
    int distance = 0;
    public int findDistance(TreeNode root, int p, int q) {
        findDistanceDFS(root, p, q, 0);

        return distance;
    }

    private ReturnNode findDistanceDFS(TreeNode root, int p, int q, int height) {
        if (root == null) {
            return null;
        }



        ReturnNode left = findDistanceDFS(root.left, p, q, height + 1);
        ReturnNode right = findDistanceDFS(root.right, p, q, height + 1);

        if (root.val == p || root.val == q) {
            if (left != null) {
                distance = left.height - height;
                return null;
            } else if (right != null) {
                distance = right.height - height;
                return null;
            } else {
                return new ReturnNode(true, height);
            }
        }

        if (left != null && right != null) {
            distance = left.height - height + right.height - height;
            return null;
        } else if (left != null) {
            return new ReturnNode(true, left.height);
        } else if (right != null){ // right != null
            return new ReturnNode(true, right.height);
        } else {
            return null;
        }
    }

    private class ReturnNode {
        boolean found;
        int height;

        public ReturnNode(boolean found, int height) {
            this.found = found;
            this.height = height;
        }
    }
}
