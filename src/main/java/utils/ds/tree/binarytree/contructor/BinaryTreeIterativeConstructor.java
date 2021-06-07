package utils.ds.tree.binarytree.contructor;

import org.apache.commons.lang3.Validate;
import utils.ds.tree.binarytree.model.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class BinaryTreeIterativeConstructor<T> implements BinaryTreeConstructor<T> {
    private static final Random random = new Random();
    private static final int MAX_RAND_NUM = 250;

    @Override
    public BinaryTreeNode<T> constructFromPrePost(List<T> pre, List<T> post) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> constructFromInPre(List<T> in, List<T> pre) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> constructFromInPost(List<T> in, List<T> post) {
        return null;
    }

    @Override
    public BinaryTreeNode<Integer> constructFromBracketString(String in, Character leftBracket, Character rightBracket) {
        Validate.notNull(in, "input string cannot be null");

        boolean[] treeStructure = new boolean[in.length()];
        char[] chars = in.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == leftBracket) {
                treeStructure[i] = true;
            } else if (chars[i] == rightBracket) {
                treeStructure[i] = false;
            }
        }

        return buildTreeInOrder(treeStructure);
    }

    /**
     * Build binary tree from bracket string
     *
     * @param word the bracket array, true is '(', false is ')'
     *
     * @return root of the binary tree
     * (())() ->  a
     *          /    \
     *         b     c
     * */
    private static BinaryTreeNode<Integer> buildTreeInOrder(boolean[] word) {
        Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
        boolean insertRight = false;
        BinaryTreeNode<Integer> root = null;
        BinaryTreeNode<Integer> currentNode = null;

        for (int i = 0; i < word.length; i++) {
            if (word[i]) {
                BinaryTreeNode<Integer> previousNode = currentNode;
                currentNode = new BinaryTreeNode<>(random.nextInt(MAX_RAND_NUM));

                if (root == null) {
                    root = currentNode;
                } else if (insertRight) {
                    previousNode.right = currentNode;
                    insertRight = false;
                } else {
                    previousNode.left = currentNode;
                }

                stack.push(currentNode);
            } else {
                currentNode = stack.pop();
                insertRight = true;
            }
        }
        return root;
    }
}
