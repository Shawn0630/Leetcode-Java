package utils.ds.tree.binarytree.contructor;

import org.apache.commons.lang3.Validate;
import utils.ds.tree.binarytree.model.BinaryTreeNode;

import java.util.List;

public class BinaryTreeRecursiveConstructor<T> implements BinaryTreeConstructor<T> {

    private int pre_order_index;

    @Override
    public BinaryTreeNode<T> constructFromPrePost(List<T> pre, List<T> post) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> constructFromInPre(List<T> in, List<T> pre) {
        pre_order_index = 0;
        Validate.notNull(in, "in-order list cannot be null");
        Validate.notNull(pre, "pre-order list cannot be null");
        if (in.size() != pre.size()) {
            throw new IllegalArgumentException("the size of in-order list is not equal to that of pre-order list");
        }

        return buildTreeInPre(in, pre, 0, in.size() - 1);
    }

    @Override
    public BinaryTreeNode<T> constructFromInPost(List<T> in, List<T> post) {
        return null;
    }

    @Override
    public BinaryTreeNode<Integer> constructFromBracketString(String in, Character leftBracket, Character rightBracket) {
        return null;
    }

    private BinaryTreeNode<T> buildTreeInPre(List<T> preorder, List<T> inorder,
                                             int left_in_order, int right_in_order) {
        if (pre_order_index >= preorder.size() || left_in_order > right_in_order) {
            return null;
        }
        T root = preorder.get(pre_order_index++);
        int index;
        for (index = left_in_order; index <= right_in_order; index++) {
            if (inorder.get(index) == root) break;
        }

        BinaryTreeNode<T> rootNode = new BinaryTreeNode<>(root);
        BinaryTreeNode<T> leftNode = buildTreeInPre(preorder, inorder, left_in_order, index - 1);
        BinaryTreeNode<T> rightNode = buildTreeInPre(preorder, inorder, index + 1, right_in_order);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }
}
