package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }


    // pitfall one: no additional to the queue while polling
    // pitfall two: should poll first then take other actions.
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    nodes.add(node);
                }
            }

            for(TreeNode node : nodes) {
                queue.add(node.left);
                queue.add(node.right);
            }

            if (!nodes.isEmpty()) {
                list.add(nodes.get(nodes.size() - 1).val);
            }
        }


        return list;
    }
}
