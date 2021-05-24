package com.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindModeinBinarySearchTree {
    // https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/668218/Java-beats-100-solution-0ms
    Integer prev;
    int curMax = Integer.MIN_VALUE;
    int count = 0;
    List<Integer> list;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        findModeDFS(root);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findModeDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        int val = root.val;

        findModeDFS(root.left);

        if (prev == null || root.val != prev) count = 1;
        else count++;
        if (count >= curMax) {
            if (count > curMax) {
                curMax = count;
                list.clear();
            }
            list.add(val);
        }
        prev = val;

        findModeDFS(root.right);
    }
}
