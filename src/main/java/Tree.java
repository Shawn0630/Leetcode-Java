import javafx.util.Pair;

import java.util.Stack;

public class Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    enum ActionType {
        CALL, LEFT_CALLBACK, RIGHT_CALLBACK
    }

    public String preorder(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if (root.left != null) {
            sb.append("(");
            sb.append(preorder(root.left));
            sb.append(")");
        }

        if (root.right != null) {
            sb.append(",");
            sb.append("(");
            sb.append(preorder(root.right));
            sb.append(")");
        }

        return sb.toString();
    }

    public String preorder_nonRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null) {
            sb.append(preorder_stack(root.left));
        }
        if (root.right != null) {
            sb.append(",");
            sb.append(preorder_stack(root.right));
        }

        return sb.toString();
    }


    public String preorder_stack(TreeNode root) {
        Stack<Pair<TreeNode, ActionType>> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(new Pair<>(root, ActionType.CALL));

        while (!stack.empty()) {
            Pair<TreeNode, ActionType> pair = stack.pop();
            TreeNode node = pair.getKey();
            ActionType type = pair.getValue();
            switch (type) {
                case CALL:
                    sb.append("(");
                    sb.append(node.val);
                    if (node.left != null) {
                        stack.push(new Pair<>(node, ActionType.LEFT_CALLBACK));
                        stack.push(new Pair<>(node.left, ActionType.CALL));
                    }
                    break;
                case LEFT_CALLBACK:
                    sb.append(")");
                    if (node.right != null) {
                        sb.append(",");
                        stack.push(new Pair<>(node, ActionType.RIGHT_CALLBACK));
                        stack.push(new Pair<>(node.right, ActionType.CALL));
                    }
                    break;
                case RIGHT_CALLBACK:
                    sb.append(")");
            }

        }
        sb.append(")");

        return sb.toString();
    }

}
