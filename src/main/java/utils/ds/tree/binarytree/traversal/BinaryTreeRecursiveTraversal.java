package utils.ds.tree.binarytree.traversal;

import utils.ds.tree.binarytree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTreeRecursiveTraversal<T> implements BinaryTreeTraversal<T> {
    @Override
    public List<T> inorderTraversal(BinaryTreeNode<T> root) {
        List<T> output = new ArrayList<>();

        inorderTraversal(root, output);

        return output;
    }

    @Override
    public List<T> postorderTraversal(BinaryTreeNode<T> root) {
        return null;
    }

    @Override
    public void postorderTraversal(BinaryTreeNode<T> root, Consumer<T> before, Consumer<T> after) {

    }

    @Override
    public void inorderTraversal(BinaryTreeNode<T> root, Consumer<T> before, Consumer<T> after) {

    }

    private void inorderTraversal(BinaryTreeNode<T> root, List<T> output) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, output);
        output.add(root.val);
        inorderTraversal(root.right, output);
    }
}
