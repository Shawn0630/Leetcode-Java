package com.tree;

import com.visualization.VisualizationUtils;
import org.algorithm_visualizer.Array2DTracer;
import org.algorithm_visualizer.Commander;
import org.algorithm_visualizer.GraphTracer;
import org.algorithm_visualizer.Layout;
import org.algorithm_visualizer.LogTracer;
import org.algorithm_visualizer.Tracer;
import org.algorithm_visualizer.VerticalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    private static GraphTracer treeTracer = new GraphTracer("Traversal Zigzag-order");
    private static Array2DTracer arrayTracer = new Array2DTracer("Print Zigzag-order");
    private static LogTracer logger = new LogTracer("Log");

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/1421593/Java-or-Beats-100
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                nodes.add(treeNode);
            }
            boolean reverse = result.size() % 2 == 1;
            int nodeSize = nodes.size();
            Integer[] levelOrder = new Integer[nodeSize];
            for (int i = 0; i < nodeSize; i++) {
                TreeNode node = nodes.get(i);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (reverse) {
                    levelOrder[nodeSize - i - 1] = node.val;
                } else {
                    levelOrder[i] = node.val;
                }
            }
            // visualize {
                for(int i = 0; i < levelOrder.length; i++) {
                    treeTracer.select(levelOrder[i]);
                    Tracer.delay();
                }
            // }
            result.add(Arrays.asList(levelOrder));
            // visualize {
            arrayTracer.set(result);
            // }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        VisualizationUtils.configureGraphTracerByBinaryTree(treeTracer, root);
        treeTracer.layoutTree(root.val);
        arrayTracer.set(new ArrayList<>());
        Layout.setRoot(new VerticalLayout(new Commander[]{treeTracer, arrayTracer, logger}));
        Tracer.delay();
        zigzagLevelOrder(root);
    }
}
