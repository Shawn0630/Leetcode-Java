package com.linked_list;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            prev = swap(prev, cur.next.next);
            cur = prev.next;
        }

        return dummy.next;
    }

    // [start -> a -> b -> end] => [start -> b -> a -> end] return end
    private ListNode swap(ListNode start, ListNode end) {
        ListNode a = start.next;
        ListNode b = a.next;

        start.next = b;
        a.next = end;
        b.next = a;

        return a;
    }
}
