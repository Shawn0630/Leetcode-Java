package com.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        findAllPaths(root, sum, ans, temp);//sum can be less than 0

        return ans;
    }


    public void findAllPaths(TreeNode currentNode, int remain, List<List<Integer>> ans, List<Integer> temp) {
        if (currentNode == null) {
            return;
        }

        // do thing on current level - process node
        temp.add(currentNode.val);
        remain = remain - currentNode.val;


        if (remain == 0 && currentNode.left == null && currentNode.right == null) {
            ans.add(new ArrayList<>(temp)); // important!!!, don't return!!!
        }

        findAllPaths(currentNode.left, remain, ans, temp);
        findAllPaths(currentNode.right, remain, ans, temp);

        // undo things on current level
        temp.remove(temp.size() - 1);
    }

}
