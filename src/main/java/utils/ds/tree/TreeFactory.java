package utils.ds.tree;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;
import utils.ds.st.SegmentTreeNode;
import utils.ds.tree.binarytree.model.BinaryTreeNode;
import utils.ds.tree.model.TreeNode;
import utils.ds.tree.visualization.TextInBox;

import java.util.function.Function;

public class TreeFactory {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 20;

    @SuppressWarnings("unchecked")
    public static <T, K extends TreeNode<T>> TreeForTreeLayout<TextInBox> buildTree(K node, Function<K, String> labelGenerator) {
        TextInBox root = new TextInBox(labelGenerator.apply(node), WIDTH, HEIGHT);
        DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<>(root);

        if (node instanceof SegmentTreeNode) {
            convertSegmentTree(tree, root, (SegmentTreeNode<T>) node, labelGenerator);
        } else if (node instanceof BinaryTreeNode) {
            convertBinaryTree(tree, root, (BinaryTreeNode<T>) node, labelGenerator);
        }

        return tree;
    }

    @SuppressWarnings("unchecked")
    private static <T, K extends TreeNode<T>> void convertBinaryTree(DefaultTreeForTreeLayout<TextInBox> tree,
                                                                     TextInBox root, BinaryTreeNode<T> node,
                                                                     Function<K, String> labelGenerator) {
        if (node.left != null) {
            TextInBox left = new TextInBox(labelGenerator.apply((K) node.left), WIDTH, HEIGHT);
            tree.addChild(root, left);
            convertBinaryTree(tree, left, node.left, labelGenerator);
        }
        if (node.right != null) {
            TextInBox right = new TextInBox(labelGenerator.apply((K) node.right), WIDTH, HEIGHT);
            tree.addChild(root, right);
            convertBinaryTree(tree, right, node.right, labelGenerator);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T, K extends TreeNode<T>> void convertSegmentTree(DefaultTreeForTreeLayout<TextInBox> tree,
                                                                      TextInBox root, SegmentTreeNode<T> node,
                                                                      Function<K, String> labelGenerator) {
        if (node.left != null) {
            TextInBox left = new TextInBox(labelGenerator.apply((K) node.left), WIDTH, HEIGHT);
            tree.addChild(root, left);
            convertSegmentTree(tree, left, node.left, labelGenerator);
        }
        if (node.right != null) {
            TextInBox right = new TextInBox(labelGenerator.apply((K) node.right), WIDTH, HEIGHT);
            tree.addChild(root, right);
            convertSegmentTree(tree, right, node.right, labelGenerator);
        }
    }
}
