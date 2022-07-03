package com.linked_list;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode slow = headA;
        ListNode fast = headA;

        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode start = headA;
                while (start != slow) {
                    start = start.next == null ? headB : start.next;
                    slow = slow.next == null ? headB : slow.next;
                }
                node.next = null;
                return start;
            }
        }

        node.next = null;
        return null;

    }
}
