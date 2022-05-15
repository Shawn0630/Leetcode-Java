package com.linked_list;

public class ReverseLinkedList {
    //      1 ->        2 ->     3    -> null
    //      p           c
    //          <-      p        c
    //                      <-   p      c
    // next = c.next;
    // p = c;
    // c.next = p;
    //
    public ListNode reverseList(ListNode head) {
        // https://leetcode.com/problems/reverse-linked-list/discuss/1449712/Easy-C%2B%2BJavaPythonJavaScript-Explained%2BAnimated
        if (head == null) {
            return null;
        }// head != null

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }// cur == null;

        return prev;
    }
}
