package com.linked_list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartitionListTest {
    PartitionList pl = new PartitionList();

    @Test
    public void test1() {

        //1->2->2->4->3->5
        PartitionList.ListNode node1 = new PartitionList.ListNode(1);
        PartitionList.ListNode node2 = new PartitionList.ListNode(2);
        PartitionList.ListNode node22 = new PartitionList.ListNode(2);
        PartitionList.ListNode node4 = new PartitionList.ListNode(4);
        PartitionList.ListNode node3 = new PartitionList.ListNode(3);
        PartitionList.ListNode node5 = new PartitionList.ListNode(5);

        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node22;

        PartitionList.ListNode result = pl.partition(node1, 3);
        int[] expected = new int[]{1, 2, 2, 4, 3, 5};
        for(int i : expected) {
            assertEquals(i, result.val);
            result = result.next;
        }
    }
}
