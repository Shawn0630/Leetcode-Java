package com.tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {


    //                    a(0,0)
    //            b(1,-1)                 c(1,1)
    //      d(2, -2)      e(2,0) (2,0)f           g(2,2)

    // [3,9,8,4,0,1,7,null,null,null,2,5]

    //                          3
//                9                           8
    //        4       0               1               7
    //                    2      5
    Map<Integer, List<Pair<Integer, Integer>>> map; // col, <row, int>
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>(); // col => (row => nodes)
        verticalOrderDFS(root, 0, 0);


        List<List<Integer>> ans = new ArrayList<>();

        for(int i = minCol; i <= maxCol; i++) {
            List<Pair<Integer, Integer>> pairs = map.get(i);
            Collections.sort(pairs, (a, b) -> a.getKey() - b.getKey());
            List<Integer> level = new ArrayList<>();
            for(Pair<Integer, Integer> row : pairs) {
                level.add(row.getValue());
            }

            ans.add(level);
        }

        return ans;
    }

    public List<List<Integer>> verticalOrder2(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();// col => [...]
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>(); // use linkedList as queue
        queue.offer(new Pair<>(0, root));
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Pair<Integer, TreeNode>> list = new ArrayList<>();
            while (size > 0) {
                list.add(queue.poll());
                size--;
            }

            for(Pair<Integer, TreeNode> pair : list) {
                int col = pair.getKey();
                TreeNode node = pair.getValue();
                if (node == null) continue;
                map.putIfAbsent(pair.getKey(), new ArrayList<>());
                map.get(col).add(node.val);
                minCol = Math.min(col, minCol);
                maxCol = Math.max(col, maxCol);

                queue.offer(new Pair<>(col - 1, node.left));
                queue.offer(new Pair<>(col + 1, node.right));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    private void verticalOrderDFS(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair<>(row, root.val));

        verticalOrderDFS(root.left, row + 1, col - 1);
        verticalOrderDFS(root.right, row + 1, col + 1);
    }
}
