package utils.ds.tree.binarytree.traversal;

import utils.ds.tree.binarytree.model.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTreeIterativeTraversal<T> implements BinaryTreeTraversal<T> {
    @Override
    public List<T> inorderTraversal(BinaryTreeNode<T> root) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        List<T> output = new ArrayList<>();

        BinaryTreeNode<T> curr = root;

        // traverse the tree
        while (curr != null || stack.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                stack.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = stack.pop();
            output.add(curr.val);

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }

        return output;
    }

    @Override
    public List<T> postorderTraversal(BinaryTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        List<T> output = new ArrayList<>();

        stack.push(root);
        BinaryTreeNode<T> prev = null;

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.peek();
            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    BinaryTreeNode<T> node = stack.pop();
                    output.add(node.val);
                }
            /* go up the tree from left node, if the child is right
            push it onto stack otherwise process parent and pop
            stack */
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    BinaryTreeNode<T> node = stack.pop();
                    output.add(node.val);
                }
            /* go up the tree from right node and after coming back
            from right node process parent and pop stack */
            } else if (current.right == prev) {
                BinaryTreeNode<T> node = stack.pop();
                output.add(node.val);
            }

            prev = current;
        }

        return output;
    }

    @Override
    public void postorderTraversal(BinaryTreeNode<T> root, Consumer<T> before, Consumer<T> after) {
        if (root == null) {
            return;
        }
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();

        stack.push(root);
        before.accept(root.val);
        BinaryTreeNode<T> prev = null;

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.peek();
            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                    before.accept(current.left.val);
                } else if (current.right != null) {
                    stack.push(current.right);
                    before.accept(current.right.val);
                } else {
                    BinaryTreeNode<T> node = stack.pop();
                    after.accept(node.val);
                }
            /* go up the tree from left node, if the child is right
            push it onto stack otherwise process parent and pop
            stack */
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                    before.accept(current.right.val);
                } else {
                    BinaryTreeNode<T> node = stack.pop();
                    after.accept(node.val);
                }
            /* go up the tree from right node and after coming back
            from right node process parent and pop stack */
            } else if (current.right == prev) {
                BinaryTreeNode<T> node = stack.pop();
                after.accept(node.val);
            }

            prev = current;
        }
    }

    @Override
    public void inorderTraversal(BinaryTreeNode<T> root, Consumer<T> before, Consumer<T> after) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();

        BinaryTreeNode<T> curr = root;

        // traverse the tree
        while (curr != null || stack.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                stack.push(curr);
                before.accept(curr.val);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = stack.pop();
            after.accept(curr.val);

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
}
