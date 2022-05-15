package com.tree;

public class DiameterofBinaryTree {
    //[1,2]
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        int left = 0, right = 0;
//        if (root.left != null) {
//            left = diameterOfBinaryTreeDFS(root.left) + 1;
//        }
//        if (root.right != null) {
//            right = diameterOfBinaryTreeDFS(root.right) + 1;
//        }

        diameterOfBinaryTreeDFS(root);

        return longest;
    }

    private int diameterOfBinaryTreeDFS(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = 0, right = 0;
        if (root.left != null) {
            left = diameterOfBinaryTreeDFS(root.left);
        }
        if (root.right != null) {
            right = diameterOfBinaryTreeDFS(root.right);
        }
        longest = Math.max(longest, left + right);
        return Math.max(left, right) + 1;
    }



    // not the height
    int globalLongest = Integer.MIN_VALUE;
    public int diameterOfBinaryTree2(TreeNode root) {
        diameterOfBinaryTree2DFS(root);

        return globalLongest;
    }

    public int diameterOfBinaryTree2DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = diameterOfBinaryTree2DFS(root.left);
        int right = diameterOfBinaryTree2DFS(root.right);

        globalLongest = Math.max(left + right, globalLongest);

        return Math.max(left, right) + 1;
    }
}
