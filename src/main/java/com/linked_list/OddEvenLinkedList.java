package com.linked_list;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }

        boolean isOdd = true;
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);

        ListNode curOdd = dummyOdd;
        ListNode curEven = dummyEven;

        ListNode cur = head;
        while (cur != null) {
            if(isOdd) {
                isOdd = false;
                curOdd.next = cur;
                curOdd = cur;
            } else {
                isOdd = true;
                curEven.next = cur;
                curEven = cur;
            }

            cur = cur.next;
        }

        curOdd.next = dummyEven.next;
        curEven.next = null;

        return dummyOdd.next;
    }
}
