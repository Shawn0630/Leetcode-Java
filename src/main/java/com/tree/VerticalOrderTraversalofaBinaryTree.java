package com.tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversalofaBinaryTree {

    /**
     *          1
     *      2       3
     *    4  6     5  7
     *
     *
     *
     * [3,1,4,0,2,2]
     *              3
     *       1              4
     *   0       2       2
     */

    Map<Integer, List<Pair<Integer, Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        verticalTraversalDFS(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Pair<Integer, Integer>> value : map.values()) {
            value.sort(((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return a.getKey() - b.getKey();
                } else {
                    return a.getValue() - b.getValue();
                }
            }));
            ans.add(value.stream().map(Pair::getKey).collect(Collectors.toList()));
        }

        return ans;
    }

    private void verticalTraversalDFS(TreeNode root, int column, int row) {
        if (root == null) {
            return;
        }

        map.putIfAbsent(column, new ArrayList<>());
        map.get(column).add(new Pair<>(root.val, row));

        verticalTraversalDFS(root.left, column - 1, row + 1);
        verticalTraversalDFS(root.right, column + 1, row + 1);
    }
}
