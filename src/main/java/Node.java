public class Node {
    Node left, right;
    int data;
    Node(int newData) {
        left = right = null;
        data = newData;
    }

    public static int isPresent(Node root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.data == val) {
            return 1;
        }

        if (root.data < val) {
            return isPresent(root.right, val);
        }

        return isPresent(root.left, val);
    }
}

