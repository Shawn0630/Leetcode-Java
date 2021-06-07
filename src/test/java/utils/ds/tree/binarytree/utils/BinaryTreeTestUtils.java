package utils.ds.tree.binarytree.utils;

import utils.ds.tree.binarytree.model.BinaryTreeNode;

public class BinaryTreeTestUtils {
    public static <T> BinaryTreeNode<T> node(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right){
        BinaryTreeNode<T> root = new BinaryTreeNode<>(elem);
        root.left = left;
        root.right = right;
        return root;
    }
}
