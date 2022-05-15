package com.tree;

public class SumofRootToLeafBinaryNumbers {

    //              0
    //      1(01)          0(00)
    //   1(011)      0     1         0
    //         1

    // 0 = 0;
    // 01 = 0 * 2 + 1 = 1
    // 011 = 1 * 2 + 1 = 3
    int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        sumRootToLeaf(root, 0);

        return sum;
    }

    private void sumRootToLeaf(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }

        curSum = curSum * 2 + root.val;

        if (root.left == null && root.right == null) { // is leaf
            sum += curSum;
        } else {
            sumRootToLeaf(root.left, curSum);
            sumRootToLeaf(root.right, curSum);
        }
    }
}
