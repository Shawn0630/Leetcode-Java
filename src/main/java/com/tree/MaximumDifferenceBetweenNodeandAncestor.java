package com.tree;

public class MaximumDifferenceBetweenNodeandAncestor {
    int ans;

    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        if (root == null) {
            return ans;
        }

        dfs(root, root.val, root.val);

        return ans;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        int diff = Math.max(root.val - min, max - root.val);
        ans = Math.max(ans, diff);

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }


    int maxDiff = 0;
    public int maxAncestorDiff2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxDfs(root, root.val, root.val);

        return maxDiff;
    }

    public void maxDfs(TreeNode root, int max, int min) {
        if(root == null) {
            return;
        }

        maxDiff = Math.max(Math.abs(max - root.val), maxDiff);
        maxDiff = Math.max(Math.abs(min - root.val), maxDiff);

        maxDfs(root.left, Math.max(max, root.val), Math.min(min, root.val));
        maxDfs(root.right, Math.max(max, root.val), Math.min(min, root.val));
    }
}
