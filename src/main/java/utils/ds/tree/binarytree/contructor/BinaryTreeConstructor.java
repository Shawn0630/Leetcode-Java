package utils.ds.tree.binarytree.contructor;

import utils.ds.tree.binarytree.model.BinaryTreeNode;

import java.util.List;

public interface BinaryTreeConstructor<T> {
    BinaryTreeNode<T> constructFromPrePost(List<T> pre, List<T> post);
    BinaryTreeNode<T> constructFromInPre(List<T> in, List<T> pre);
    BinaryTreeNode<T> constructFromInPost(List<T> in, List<T> post);
    BinaryTreeNode<Integer> constructFromBracketString(String in, Character leftBracket, Character rightBracket);
}
