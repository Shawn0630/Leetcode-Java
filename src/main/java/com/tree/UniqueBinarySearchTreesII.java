package com.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    // https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/1168576/Java-easy-Solution
    public List<TreeNode> generateTrees(int n) {
        return constructTrees(1, n);
    }

    public List<TreeNode> constructTrees(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = constructTrees(start, i - 1);
            List<TreeNode> right = constructTrees(i + 1, end);

            for (int j = 0; j < left.size(); j++) {
                TreeNode leftNode = left.get(j);
                for (int k = 0; k < right.size(); k++) {
                    TreeNode rightNode = right.get(k);
                    TreeNode midNode = new TreeNode(i);

                    midNode.left = leftNode;
                    midNode.right = rightNode;
                    nodes.add(midNode);
                }
            }
        }

        return nodes;
    }
}
