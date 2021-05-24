package com.tree;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/1183412/O(n)%2BO(n)%3A-Summary-of-preorder%2Bpostorder(LC889)-VS-preorder-%2B-inorder(LC105)-to-construct-tree
    // https://stackoverflow.com/questions/33062228/why-it-is-impossible-to-construct-binary-tree-with-pre-order-post-order-and-lev
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/939552/Full-explanation.-Best-O(n)-solution-(no-auxiliary-Hash-no-index-search-recursive-Python-3)

    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null ||
            pre.length != post.length) {
            return null;
        }

        if (preIndex >= pre.length || postIndex >= post.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;

        if (root.val != post[postIndex]) {
            root.left = constructFromPrePost(pre, post);
            if (root.val != post[postIndex]) {
                root.right = constructFromPrePost(pre, post);
            }
        }

        postIndex++;

        return root;
    }
}
