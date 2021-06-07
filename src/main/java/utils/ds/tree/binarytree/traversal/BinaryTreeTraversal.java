package utils.ds.tree.binarytree.traversal;

import utils.ds.tree.binarytree.model.BinaryTreeNode;

import java.util.List;
import java.util.function.Consumer;

public interface BinaryTreeTraversal<T> {
    List<T> inorderTraversal(BinaryTreeNode<T> root);
    List<T> postorderTraversal(BinaryTreeNode<T> root);
    void postorderTraversal(BinaryTreeNode<T> root, Consumer<T> before, Consumer<T> after);
    void inorderTraversal(BinaryTreeNode<T> root, Consumer<T> before, Consumer<T> after);
}
