package com.linked_list;

public class ReverseLinkedListII {

    //      l:2, r:4
    //      1    2   3   4   5   6
    //k     0    1
    //      prev
    //           cur
    //
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right <= left) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode prev = dummy;
        ListNode cur = head;

        int k = 0;
        while (cur != null && k < left - 1) { // [0 1]  < 1
            prev = prev.next;
            cur = cur.next;
            k++;
        }
        ListNode leftNodePrev = prev;
        ListNode leftNode = cur;

        while(cur != null && k < right - 1) {
            prev = prev.next;
            cur = cur.next;
            k++;
        }

        ListNode rightNode = cur;

        reverseBetween(leftNodePrev, leftNode, rightNode);

        return dummy.next;
    }



    //  p               s                               e
    //  1       ->      2       ->      3       ->      4
    //                                  n
    // temp = p.next
    //  p -> n                  1 -> 3 <- 2
    //  s -> n.next;
    //  n -> temp;              1 -> 3 -> 2
    //

    // https://leetcode.com/problems/reverse-linked-list-ii/discuss/30709/Talk-is-cheap-show-me-the-code-(and-DRAWING)
    private void reverseBetween(ListNode prev, ListNode start, ListNode end) {
        while (prev.next != end) {
           ListNode tmp = prev.next;
           prev.next = start.next;
           start.next = start.next.next;
           prev.next.next = tmp; // fix two side // next next

        }
    }

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        reverseLinkedListII.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 2, 4);
    }

    // 2->5->4->3

}
