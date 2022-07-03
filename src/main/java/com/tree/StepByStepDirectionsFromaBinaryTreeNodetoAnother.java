package com.tree;

import javafx.util.Pair;
import jdk.nashorn.internal.ir.ReturnNode;

import java.util.LinkedList;
import java.util.Queue;

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother {

    // https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/1964920/One-time-build-path-while-finding-LCA
    // if 0 not found, 1 findstart, 2 finddest, 3 findboth

    // https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/2189561/JS-3-step-(LCA-%2B-intermediate-path-generation-%2B-get-final-path)

    // https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/2189250/Python-BFS-Solution
    // TODO
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();

        String start = "";
        String dest = "";
        queue.offer(new Pair<>(root, ""));

        while (!queue.isEmpty()) {
            Pair<TreeNode, String> pair = queue.poll();
            if (pair.getKey() == null) {
                continue;
            }

            if (pair.getKey().val == startValue) {
                start = pair.getValue();
            } else if (pair.getKey().val == destValue) {
                dest = pair.getValue();
            }

            queue.offer(new Pair<>(pair.getKey().left, pair.getValue() + "L"));
            queue.offer(new Pair<>(pair.getKey().right, pair.getValue() + "R"));
        }

        for(int i = 0; i < Math.max(start.length(), dest.length()); i++) {
            if (i == start.length()) {
                return dest.substring(i);
            } else if (i == dest.length()) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < start.length() - i; j++) {
                    sb.append('U');
                }

                return sb.toString();
            } else if (start.charAt(i) != dest.charAt(i)) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < start.length() - i; j++) {
                    sb.append('U');
                }

                return sb.toString() + dest.substring(i);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        StepByStepDirectionsFromaBinaryTreeNodetoAnother stepByStepDirectionsFromaBinaryTreeNodetoAnother = new StepByStepDirectionsFromaBinaryTreeNodetoAnother();
        stepByStepDirectionsFromaBinaryTreeNodetoAnother.getDirections(new TreeNode(2, new TreeNode(1, null, null), null), 2, 1);
    }
}
