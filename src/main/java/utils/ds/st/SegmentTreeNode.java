package utils.ds.st;

import utils.ds.tree.model.TreeNode;

public class SegmentTreeNode<T> extends TreeNode<T> {
    public int start, end;
    public T attribute;
    public SegmentTreeNode<T> left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
    public SegmentTreeNode(int start, int end, T attribute) {
        this(start, end);
        this.attribute = attribute;
    }
}