package com.tree;

import org.junit.Test;

public class InsertintoaBinarySearchTreeTest {

    InsertintoaBinarySearchTree ibst = new InsertintoaBinarySearchTree();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(40);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(60);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(30);
        TreeNode node5 = new TreeNode(50);
        TreeNode node6 = new TreeNode(70);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(55);
        TreeNode node1 = new TreeNode(28);
        TreeNode node2 = new TreeNode(92);
        TreeNode node3 = new TreeNode(26);
        TreeNode node4 = new TreeNode(43);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        ibst.insertIntoBST(root, 1);
    }

}
