package com.linked_list;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = dummy;
            while (node != cur && node.next != null && node.next.val <= cur.val) {
                node = node.next;
            }

            if (node != cur) {
                prev.next = cur.next;
                cur.next = node.next;
                node.next = cur;

                cur = prev.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }

        }

        return dummy.next;
    }
}
