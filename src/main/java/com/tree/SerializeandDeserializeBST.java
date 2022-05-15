package com.tree;

public class SerializeandDeserializeBST {

    // Encodes a tree to a single string.

    //          3
    //   1             4
    //                      5
    // => 3, 1, 4, null, 5
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        idx = 0;
        return deserialize(array);
    }

    private TreeNode deserialize(String[] array) {
        if (idx >= array.length) {
            return null;
        }

        String cur = array[idx++];
        if (cur.equals("null")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(cur));
            root.left = deserialize(array);
            root.right = deserialize(array);
            return root;
        }
    }
}
