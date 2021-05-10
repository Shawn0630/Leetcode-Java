package utils.ds.tree.model;

import java.util.List;

public class TreeNode<T> {
    /**
     * Information associated to and stored at each node. This can be anything
     * and depends on the application, for example, string label, key-value pair,
     * list of values, etc.
     */
    public T val;
    /**
     * Array of pointers to this node's children. The order of children is
     * significant due to the definition of ordered trees.
     */
    public List<TreeNode<T>> children;

    public TreeNode() {};

    public TreeNode(T val) {
        this.val = val;
    }
}
