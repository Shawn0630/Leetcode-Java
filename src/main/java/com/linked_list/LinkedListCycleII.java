package com.linked_list;

public class LinkedListCycleII {
    // head = [3,2,0,-4], pos = 1

    //             -    -      -
    //          |               |
    //  3       2       0       -4
    //  f,s
    //          s       f
    //          f       s
    //                          sf
    //          s       f
    //          f       s
    //                          sf

    //          -
    //      |       |
    //      1       2
    //      fs
    //      f       s
    //      sf
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
