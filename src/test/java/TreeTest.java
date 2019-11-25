import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TreeTest {

    Tree tree = new Tree();
    @Test
    public void test1() {
        Tree.TreeNode root = new Tree.TreeNode(1);
        Tree.TreeNode root_left = new Tree.TreeNode(2);
        Tree.TreeNode root_right = new Tree.TreeNode(3);
        Tree.TreeNode root_left_left = new Tree.TreeNode(4);
        Tree.TreeNode root_left_right = new Tree.TreeNode(5);
        Tree.TreeNode root_left_left_left = new Tree.TreeNode(6);
        Tree.TreeNode root_left_left_right = new Tree.TreeNode(7);
        Tree.TreeNode root_right_left = new Tree.TreeNode(8);

        root.left = root_left;
        root.right = root_right;
        root_left.left = root_left_left;
        root_left.right = root_left_right;
        root_left_left.left = root_left_left_left;
        root_left_left.right = root_left_left_right;
        root_right.left = root_right_left;


        assertThat(tree.preorder(root), is("1(2(4(6),(7)),(5)),(3(8))"));
        assertThat(tree.preorder_nonRecursive(root), is(tree.preorder(root)));
    }


}
