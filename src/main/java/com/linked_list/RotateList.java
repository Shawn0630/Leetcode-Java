package com.linked_list;

public class RotateList {
    // 1 -> 2 -> 3 n = 3;
    // 3 -> 1 -> 2 k = 1
    // 2 -> 3 -> 1 k = 2
    // 1 -> 2 -> 3 k = 3
    // k = 4 ...
    public ListNode rotateRight(ListNode head, int k) {
        Returned n = getLength(head);
        k = k % n.length;
        ListNode[] returned = getK(head, n.length - k + 1); // 3 - 1 + 1
        head = returned[1];
        n.last.next = head;
        if (returned[0] != null) {
            returned[0].next = null;
        }
        return head;
    }


    private Returned getLength(ListNode head) {
        int counter = 0;
        ListNode cur = head;
        while (true) {
            counter++;
            cur = cur.next;
            if (cur.next == null) {
                return new Returned(counter, cur);
            }
        }
    }

    private ListNode[] getK(ListNode head, int k) {
        int counter = 0;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            counter++;
            if (counter == k) {
                return new ListNode[]{prev, cur};
            }
            prev = cur;
            cur = cur.next;
        }

        return null;
    }

    private class Returned {
        int length;
        ListNode last;

        public Returned(int length, ListNode last) {
            this.last = last;
            this.length = length;
        }
    }
}
