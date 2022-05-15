package com.linked_list;

public class DeletetheMiddleNodeofaLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }

        if (slow != null) {
            prev.next = slow.next;
        }

        return dummy.next;
    }
}
