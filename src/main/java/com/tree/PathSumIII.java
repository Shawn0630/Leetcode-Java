package com.tree;

public class PathSumIII {
    int count;
    int _targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        _targetSum = targetSum;
        pathSumDFS(root, targetSum, true);
        return count;
    }

    private void pathSumDFS(TreeNode root, int remaining, boolean restart) {
        if (root == null) {
            return;
        }
        int value = root.val;
        if (remaining - value == 0) {
            count++;
        }
        if (restart) {
            pathSumDFS(root.left, _targetSum, true);
            pathSumDFS(root.right, _targetSum, true);
        }
        pathSumDFS(root.left, remaining - value, false);
        pathSumDFS(root.right, remaining - value, false);
    }
}


// pathSumDFS(1, 3) =>
//   pathSumDFS(2, 3), => pathSumDFS(3, 3)
//   pathSumDFS(2, 2) => pathSumDFS(3, 3)