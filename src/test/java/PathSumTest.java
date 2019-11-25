import org.junit.Test;

import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PathSumTest {
    PathSum ps = new PathSum();

    @Test
    public void test1() {
        PathSum.TreeNode root = new PathSum.TreeNode(5);
        PathSum.TreeNode root_left = new PathSum.TreeNode(4);
        PathSum.TreeNode root_right = new PathSum.TreeNode(8);
        PathSum.TreeNode root_left_left = new PathSum.TreeNode(11);
        PathSum.TreeNode root_right_left = new PathSum.TreeNode(13);
        PathSum.TreeNode root_right_right = new PathSum.TreeNode(4);
        PathSum.TreeNode root_left_left_left = new PathSum.TreeNode(7);
        PathSum.TreeNode root_left_left_right = new PathSum.TreeNode(2);

        root.left = root_left;
        root.right = root_right;
        root_left.left = root_left_left;
        root_right.left = root_right_left;
        root_right.right = root_right_right;
        root_left_left.left = root_left_left_left;
        root_left_left.right = root_left_left_right;

        assertTrue(ps.hasPathSum(root, 22));

    }

    @Test
    public void test2() {
        assertFalse(ps.hasPathSum(null, 0));
    }

    @Test
    public void test3() {
        PathSum.TreeNode root = new PathSum.TreeNode(1);
        PathSum.TreeNode root_left = new PathSum.TreeNode(2);
        root.left = root_left;
        assertFalse(ps.hasPathSum(root, 1));
    }


    @Test
    public void test4() {
        PathSum.TreeNode root = new PathSum.TreeNode(10);
        PathSum.TreeNode left = new PathSum.TreeNode(5);
        PathSum.TreeNode right = new PathSum.TreeNode(-3);
        PathSum.TreeNode left_left = new PathSum.TreeNode(3);
        PathSum.TreeNode left_right = new PathSum.TreeNode(2);
        PathSum.TreeNode right_right = new PathSum.TreeNode(11);
        PathSum.TreeNode left_left_left = new PathSum.TreeNode(3);
        PathSum.TreeNode left_left_right = new PathSum.TreeNode(-2);
        PathSum.TreeNode left_right_right = new PathSum.TreeNode(1);

        root.left = left;
        root.right = right;
        left.left = left_left;
        left.right = left_right;
        right.right = right_right;
        left_left.left = left_left_left;
        left_left.right = left_left_right;
        left_right.right = left_right_right;

        assertThat(ps.pathSum(root, 8), is(3));
    }
}
