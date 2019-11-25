import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeMaximumPathSumTest {

    BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();

    @Test
    public void test1() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(1);
        BinaryTreeMaximumPathSum.TreeNode left = new BinaryTreeMaximumPathSum.TreeNode(2);
        BinaryTreeMaximumPathSum.TreeNode right = new BinaryTreeMaximumPathSum.TreeNode(3);
        root.left = left;
        root.right = right;

        assertThat(bt.maxPathSum(root), is(6));

    }

    @Test
    public void test2() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(-10);
        BinaryTreeMaximumPathSum.TreeNode root_left = new BinaryTreeMaximumPathSum.TreeNode(9);
        BinaryTreeMaximumPathSum.TreeNode root_right = new BinaryTreeMaximumPathSum.TreeNode(20);
        BinaryTreeMaximumPathSum.TreeNode root_right_left = new BinaryTreeMaximumPathSum.TreeNode(15);
        BinaryTreeMaximumPathSum.TreeNode root_right_right = new BinaryTreeMaximumPathSum.TreeNode(7);
        root.left = root_left;
        root.right = root_right;
        root_right.left = root_right_left;
        root_right.right = root_right_right;


        assertThat(bt.maxPathSum(root), is(42));
    }
}
