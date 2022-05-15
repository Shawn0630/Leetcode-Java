package com.linked_list;

public class ReorderList {
    // https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps
    public void reorderList(ListNode head) {
        ListNode midHead = head; // 1
        ListNode cur = head; // 1

        // 1 -> 2 -> 3
        // 1 -> 2 -> 3 -> 4
        while (cur != null && cur.next != null) {
            midHead = midHead.next; // 1.next = 2
            cur = cur.next.next; // 1.next.next = 3
        } // midhead = 2

        ListNode second = midHead.next;
        midHead.next = null;

        cur = second;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode reversed = prev;

        cur = head;
        ListNode reverseCur = reversed;
        while (reverseCur != null) {
            ListNode curNext = cur.next;
            ListNode reverseNext = reverseCur.next;
            cur.next = reverseCur;
            reverseCur.next = curNext;

            cur = curNext;
            reverseCur = reverseNext;
        }
    }
}
