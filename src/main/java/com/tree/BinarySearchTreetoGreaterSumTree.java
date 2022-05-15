package com.tree;

public class BinarySearchTreetoGreaterSumTree {
    int backtrace_sum = 0;
    // https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/discuss/1498976/Simple-Java-solution-using-Iterative-solution-100-time
    public TreeNode bstToGst(TreeNode root) {
        bstToGstHelper(root);
        return root;
    }

    private void bstToGstHelper(TreeNode root){
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            root.val = backtrace_sum + root.val;
            backtrace_sum = root.val;
        } else {
            if (root.right != null) {
                bstToGstHelper(root.right);
            }
            root.val = backtrace_sum + root.val;
            backtrace_sum = root.val;
            if (root.left != null) {
                bstToGstHelper(root.left);
            }
            return;
        }
    }
}

// helper(4, 0) => root.val = 4 + 26 = 30 => helper(1, 30) =>
//                                           helper(2, 30) => root.val = 2 + 33 = 35
//                                           helper(3, 30) => root.val = 3 + 30 = 33
//
// helper(6, 0) => root.val = 15 + 6 = 21
//                                        => helper(5, 21)
//                                          root.val = 5 + 21 = 26 return 26
// helper(7, 0) => root.val = 8 + 7 = 15, return 15
// helper(8, 0) => return 0 + 8 = 8

// [3,2,4,1]
// [7,9,4,10]

// helper(3, 0)
//   root.val = 3 + 4 = 7  helper(7, 2)
// helper(4, 0) => return 0 + 4 = 4