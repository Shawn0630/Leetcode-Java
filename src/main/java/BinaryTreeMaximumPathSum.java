public class BinaryTreeMaximumPathSum {
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDFS(root);

        return maxPathSum;
    }

    public int maxPathSumDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = root.val;
        int left = maxPathSumDFS(root.left);
        int right = maxPathSumDFS(root.right);
        max = Math.max(max, root.val + left);
        max = Math.max(max, root.val + right);
        max = Math.max(max, left + root.val + right);
        maxPathSum = Math.max(maxPathSum, max);

        return Math.max(root.val, Math.max(left, right) + root.val);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
