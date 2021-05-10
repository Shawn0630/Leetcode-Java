package com.linked_list;

public class PartitionList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode cur = head;
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }

            cur = cur.next;
        }

        cur1.next = dummy2.next;
        cur2.next = null;

        return dummy1.next;
    }
}
