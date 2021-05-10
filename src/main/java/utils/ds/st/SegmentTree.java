package utils.ds.st;

import utils.ds.tree.visualization.TreeVisualizer;
import utils.ds.tree.visualization.svg.SVGForTextInBoxTree;

import java.util.function.BiFunction;

// https://jojozhuang.github.io/algorithm/data-structure-segment-tree/
// https://leetcode.com/problems/the-skyline-problem/discuss/1174869/SegmentTree-Solution
public class SegmentTree<T> {
    /*
    * Build - O(n)
    */
    private BiFunction<T, T, T> transformer;
    private SegmentTreeNode<T> root;
    private int length;
    private TreeVisualizer visualizer;
    private static final String LABEL_FORMAT = "[%d, %d] - %s";

    private SegmentTree() {
        visualizer = new TreeVisualizer();
    }

    public SegmentTree(T[] arr, BiFunction<T, T, T> transformer) throws IllegalAccessException {
        this();
        this.transformer = transformer;
        this.root = build(arr);
        this.length = arr.length;
    }

    public SegmentTree(int size, BiFunction<T, T, T> transformer) throws IllegalAccessException {
        this();
        this.transformer = transformer;
        this.length = size;
        this.root = new SegmentTreeNode<>(0, size - 1);
    }

    public SegmentTreeNode<T> build(T[] arr) throws IllegalAccessException {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return build(arr, 0, arr.length - 1);
    }

    /*
     * Modification - O(logn)
     */
    public void build(int index, T value) throws IllegalAccessException{
        if(index >= this.length) {
            throw new IllegalAccessException("index out of bound");
        }

       build(root, index, value);
    }

    /*
     * Modification - O(logn)
     */
    public void build(int start, int end, T value) throws IllegalAccessException {
        if (start < 0 || end >= this.length) {
            throw new IllegalAccessException("index out of bound");
        }

        build(root, start, end, value);
    }

    /*
     * Modification - O(logn)
     */
    void modify(int index, T value) {
        modify(this.root, index, value);
    }


    void modify(int start, int end, T attribute) {

    }

    public void visualize() {
        visualize(root);
    }

    public String toSVG(){
        return toSVG(root);
    }

    /*
     * Search - O(logn)
     */
    public T query(int start, int end) {
        return query(this.root, start, end);
    }

    private SegmentTreeNode<T> build(T[] arr, int start, int end) throws IllegalAccessException {
        if (start > end) {
            throw new IllegalAccessException("start cannot be greater than end");
        }

        SegmentTreeNode<T> root = new SegmentTreeNode<>(start, end);
        if (start == end) {
            root.attribute = arr[start];
            return root;
        }

        int mid = (start + end) >> 1;
        root.left = build(arr, start, mid);
        root.right = build(arr, mid + 1, end);
        root.attribute = transformer.apply(root.left.attribute, root.right.attribute);
        return root;
    }

    private T query(SegmentTreeNode<T> root, int start, int end) {
        if (root == null) {
            throw new IllegalArgumentException("root cannot be null");
        }

        // case 1: search range is same with the range of root node
        if (root.start == start && root.end == end) {
            return root.attribute;
        }

        int mid = (root.start + root.end) >> 1;
        // left range = [root.start, root.mid], right range = [root.mid + 1, root.end]
        if (end <= mid) {
            // case 2: search range is in the range of left child node
            return query(root.left, start, end);
        } else if (start > mid) {
            // case 3: search range is in the range of right child node
            return query(root.right, start, end);
        } else {
            //case 4: search range crosses both left and right children
            T left = query(root.left, start, mid);
            T right = query(root.right, mid + 1, end);
            return transformer.apply(left, right);
        }
    }

    private void modify(SegmentTreeNode<T> root, int index, T value) {
        if (root == null) {
            return;
        }

        if (root.start == root.end && root.start == index) {
            root.attribute = value;
            return;
        }

        int mid = (root.start + root.end) >> 1;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }

        root.attribute = transformer.apply(root.left.attribute, root.right.attribute);
    }

    private void build(SegmentTreeNode<T> root, int start, int end, T attribute) {
        if (root == null) {
            return;
        }

        if (root.start == start && root.end == end) {
            root.attribute = transformer.apply(root.attribute, attribute);
            return;
        }

        int mid = (root.start + root.end) >> 1;
        if (root.left == null) {
            root.left = new SegmentTreeNode<>(root.start, mid);
        }
        if (root.right == null) {
            root.right = new SegmentTreeNode<>(mid + 1, root.end);
        }

        if (end <= mid) {
            build(root.left, start, end, attribute);
        } else if (start > mid) {
            build(root.right, start, end, attribute);
        } else {
            build(root.left, start, mid, attribute);
            build(root.right, mid + 1, end, attribute);
        }
        // root.attribute = transformer.apply(root.left.attribute, root.right.attribute);
    }

    private void build(SegmentTreeNode<T> root, int index, T attribute) {
        if (root == null) {
            return;
        }

        if (root.start == root.end && root.start == index) {
            root.attribute = transformer.apply(root.attribute, attribute);
            return;
        }

        int mid = (root.start + root.end) >> 1;
        if (root.left == null) {
            root.left = new SegmentTreeNode<>(root.start, mid);
        }
        if (root.right == null) {
            root.right = new SegmentTreeNode<>(mid + 1, root.end);
        }

        if (index <= mid) {
            build(root.left, index, attribute);
        } else {
            build(root.right, index, attribute);
        }

        root.attribute = transformer.apply(root.left.attribute, root.right.attribute);
    }

    private void visualize(SegmentTreeNode<T> root) {
        visualizer.visualizeTreeInSwing(root, node-> String.format(LABEL_FORMAT, node.start, node.end, node.attribute == null ? "NULL" :node.attribute.toString()));
    }

    private String toSVG(SegmentTreeNode<T> root) {
        return visualizer.toSVG(root, node-> String.format(LABEL_FORMAT, node.start, node.end, node.attribute == null ? "NULL" : node.attribute.toString()));
    }
}

