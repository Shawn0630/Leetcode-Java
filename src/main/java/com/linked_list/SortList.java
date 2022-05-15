package com.linked_list;

public class SortList {

    // https://leetcode.com/problems/sort-list/discuss/995263/Java-selection-sort-typical-top-down-merge-sort
    // LTE
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            ListNode smallest = cur;
            ListNode smallestPrev = prev;
            int smallestVal = cur.val;

            ListNode nodePrev = cur;
            ListNode node = cur.next;


            while (node != null) {
                if (node.val < smallestVal) {
                    smallestPrev = nodePrev;
                    smallest = node;
                    smallestVal = node.val;
                }
                nodePrev = nodePrev.next;
                node = node.next;
            }

            if (cur != smallest) {
                swap(prev, cur, smallestPrev, smallest);
            }

            prev = prev.next;
            cur = smallest.next;
        }

        return dummy.next;
    }

    // prev_a -> a -> .... -> prev_b -> b
    // prev_a -> b -> ...  -> prev_b -> a
    // swap two element 1) a->b 2) a->....->b 3) a->a
    private void swap(ListNode prev_a, ListNode a, ListNode prev_b, ListNode b) {
        ListNode anext = a.next;
        prev_a.next = b; // prev_a -> b
        a.next = b.next; // a -> ...
        if (a != prev_b) {
            prev_b.next = a;
            b.next = anext;
        } else {
            b.next = a;
        }
    }

    public static void main(String[] arg) {
        SortList sortList = new SortList();
        sortList.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
    }
}
