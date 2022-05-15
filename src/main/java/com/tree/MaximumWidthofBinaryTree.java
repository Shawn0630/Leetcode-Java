package com.tree;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    // [1,3,null,5,3]
    //          1
    //      3       null
    //  5       3

    //  [1,3,2,5,null,null,9,6,null,null,7]

    //                  1
    //          3               2
    //      5       null    null    9
    //  6       null             null      7
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        int maximum = Integer.MIN_VALUE;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();

            while (size > 0) {
                nodes.add(queue.poll());
                size--;
            }

            int left = 0, right = nodes.size() - 1;
            while (left < nodes.size() && nodes.get(left) == null) left++;
            while (right >= 0 && nodes.get(right) == null) right--;

            int counter = 0;
            for(int i = left; i <= right; i++) {
                TreeNode node = nodes.get(i);
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                counter++;
            }

            maximum = Math.max(maximum, counter);
        }

        return maximum;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        int maximum = Integer.MIN_VALUE;
        queue.offer(new Pair<>(root, 1));

        while (!queue.isEmpty()) {
            int size = queue.size();

            int head = queue.peek().getValue();
            int tail = 0;


            while (size > 0) {
                Pair<TreeNode, Integer> node = queue.poll();

                TreeNode treeNode = node.getKey();
                Integer col = node.getValue();

                tail = col;

                if (treeNode.left != null) {
                    queue.offer(new Pair<>(treeNode.left, 2 * col));
                }
                if (treeNode.right != null) {
                    queue.offer(new Pair<>(treeNode.right, 2 * col + 1));
                }


                size--;
            }

            maximum = Math.max(maximum, tail - head + 1);
        }

        return maximum;
    }

    //          1
    //      2       3
    //  4       6       7
    //      12       14
    //                   29

    public int widthOfBinaryTree3(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 1;

        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                nodes.add(queue.poll());
                size--;
            }

            // 0    1   2     3 4 5 6
            // null null null 3 4 5 null
            int i = 0;
            while (i < nodes.size() && nodes.get(i) == null) i++;
            int j = nodes.size() - 1;
            while (j >= 0 && nodes.get(j) == null) j--;
            for(int k = i; k <= j; k++) {
                TreeNode node = nodes.get(k);
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, j - i + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidthofBinaryTree maximumWidthofBinaryTree = new MaximumWidthofBinaryTree();
        maximumWidthofBinaryTree.widthOfBinaryTree2(new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9, null, null))));
    }
}
