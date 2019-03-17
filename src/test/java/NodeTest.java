import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NodeTest {

    @Test
    public void test1() {
        Node root = new Node(20);
        Node root_left = new Node(10);
        Node root_right = new Node(30);
        Node root_left_left = new Node(8);
        Node root_left_right = new Node(12);
        Node root_right_left = new Node(25);
        Node root_right_right = new Node(40);

        root.left = root_left;
        root.right = root_right;
        root_left.left = root_left_left;
        root_left.right = root_left_right;
        root_right.left = root_right_left;
        root_right.right = root_right_right;

        assertEquals(1, Node.isPresent(root, 30));
        assertEquals(1, Node.isPresent(root, 10));
        assertEquals(1, Node.isPresent(root, 12));
        assertEquals(0, Node.isPresent(root, 15));
    }

    @Test
    public void test2() {
        Node root = new Node(5);
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(1);

        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        assertEquals(1, Node.isPresent(root, 5));
        assertEquals(1, Node.isPresent(root, 4));
        assertEquals(1, Node.isPresent(root, 3));
        assertEquals(0, Node.isPresent(root, 6));
    }
}
