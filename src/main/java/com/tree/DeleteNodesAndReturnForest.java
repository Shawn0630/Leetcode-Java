package com.tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//[1,2,null,4,3]
//[2,3]
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        if (root == null) {
            return forest;
        }
        Set<Integer> to_delete_set = new HashSet<>();
        for(int delete : to_delete) {
            to_delete_set.add(delete);
        }
        if (!to_delete_set.contains(root.val)) {
            forest.add(root);
        }
        deleteNodeHelpers(forest, root, null, true, to_delete_set);

        return forest;
    }

    private void deleteNodeHelpers(List<TreeNode> forest, TreeNode root, TreeNode parent, boolean isLeft, Set<Integer> to_delete) {
        if (root == null) {
            return;
        } else {
            int val = root.val;
            if (to_delete.contains(val)) {
                if (parent != null) {
                    if (isLeft) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
                if (root.left != null && !to_delete.contains(root.left.val)) {
                    forest.add(root.left);
                }
                if (root.right != null && !to_delete.contains(root.right.val)) {
                    forest.add(root.right);
                }
            }
            deleteNodeHelpers(forest, root.left, root, true, to_delete);
            deleteNodeHelpers(forest, root.right, root, false, to_delete);
        }
    }
}
