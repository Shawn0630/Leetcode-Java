package utils.ds.tree.binarytree.model;

import utils.ds.tree.model.TreeNode;

public class BinaryTreeNode<T> extends TreeNode<T> {
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode() {
        super();
    }
    public BinaryTreeNode(T val) { super(val); }
    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}
