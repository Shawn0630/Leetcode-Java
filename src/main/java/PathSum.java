import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        return hasPathSumDFS(root, sum);
    }

    public boolean hasPathSumDFS(TreeNode root, int remain) {
        if (root.left == null && root.right == null) {
            if (root.val == remain) {
                return true;
            } else {
                return false;
            }
        }

        return (root.left == null ? false : hasPathSumDFS(root.left, remain - root.val)) ||
                (root.right == null ? false : hasPathSumDFS(root.right, remain - root.val));
    }

    int pathCount = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return pathCount;
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        pathSumDFS(root, sum, path);

        return pathCount;
    }


    //reverse the path from end the start, sum up in each search
    public void pathSumDFS(TreeNode root, int sum, List<Integer> path) {
        int pathSum = 0;
        for(int i = path.size() - 1; i >= 0; i--) {
            pathSum += path.get(i);
            if (pathSum == sum) {
                pathCount++;
            }
        }

        //each dfs step is the subpath of root-leaf path
        if (root.left != null) {
            path.add(root.left.val);
            pathSumDFS(root.left, sum, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            pathSumDFS(root.right, sum, path);
            path.remove(path.size() - 1);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
