package com.linked_list;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = dummy;
            while (node != cur && node.next != null && node.next.val <= cur.val) {
                node = node.next;
            }

            if (node != cur) {
                prev.next = cur.next;
                cur.next = node.next;
                node.next = cur;

                cur = prev.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }

        }

        return dummy.next;
    }


    // 4 -> 3 -> 1 -> 2  4(prev) -> 3(current)
    // 3 -> 4 -> 1 -> 2
    // 1 -> 3 -> 4 -> 2
    // 1 -> 2 -> 3 -> 4
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode current = head.next;
        ListNode sorted = head;

        while (current != null) {
            ListNode insert_prev = dummy;
            ListNode insert = dummy.next;
            while (insert != null && insert.val < current.val) {
                insert_prev = insert_prev.next;
                insert = insert.next;
            }

            if (insert == current) {
                sorted = current;
                current = current.next;
            } else {
                sorted.next = current.next;
                insert_prev.next = current;
                current.next = insert;
                current = sorted.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();

        insertionSortList.insertionSortList2(new ListNode(3, new ListNode(2, new ListNode(1))));
    }
}
