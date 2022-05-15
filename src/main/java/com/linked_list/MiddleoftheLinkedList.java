package com.linked_list;

public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null) {
            return head;
        }

        // 1    ->  2   ->  3
        // f/s
        //          s       f

        // 1    ->  2   ->  3   ->      4
        // f/s
        //          s       f
        //                  s           f
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // exit condition fast == null || fast.next == null

        return fast != null && fast.next == null ? slow.next : slow;

    }
}
