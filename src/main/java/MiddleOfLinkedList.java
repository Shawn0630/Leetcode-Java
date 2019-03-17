class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // 1 2 3
        // 2 4 NULL

        // 1 2 3 4
        // 2 4 6 NULL

        // 1 2
        // 1 2
        // 2 NULL

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode one = dummy;
        ListNode two = dummy;

        while (two != null) {
            one = one.next;
            two = two.next;
            if (two != null) {
                two = two.next;
            }
        }

        return one;

    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
