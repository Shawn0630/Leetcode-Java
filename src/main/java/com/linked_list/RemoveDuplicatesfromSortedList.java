package com.linked_list;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        /*
         * 1 -> 1 -> 2 => 1 -> 2
         * cur  next
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur != null && next != null) {
            if (cur.val == next.val) {
                cur.next = next.next;
                next = next.next;
            } else {
                cur = next;
                next = next.next;
            }
        }

        return dummy.next;
    }
}
