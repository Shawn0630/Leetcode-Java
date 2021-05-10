package com.tree;

import org.junit.Test;

public class PopulatingNextRightPointerTest {

    PopulatingNextRightPointers pnp = new PopulatingNextRightPointers();

    @Test
    public void test1() {
        TreeNodeWithNext root = new TreeNodeWithNext(1);
        TreeNodeWithNext treeNode1 = new TreeNodeWithNext(2);
        TreeNodeWithNext treeNode2 = new TreeNodeWithNext(3);
        TreeNodeWithNext treeNode3 = new TreeNodeWithNext(4);
        TreeNodeWithNext treeNode4 = new TreeNodeWithNext(5);
        TreeNodeWithNext treeNode5 = new TreeNodeWithNext(6);
        TreeNodeWithNext treeNode6 = new TreeNodeWithNext(7);

        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;


        root = pnp.connect2(root);
    }

}
