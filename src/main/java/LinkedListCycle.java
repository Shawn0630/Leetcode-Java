public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
         /*
         *
         *  3   ->   2   ->    0    ->   4
         *
         *  slow    fast
         *          slow                 fast
         *                    slow
         *                    fast
         * */

         ListNode dummy = new ListNode(0);
         dummy.next = head;

         ListNode slow = dummy;
         ListNode fast = dummy;

         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {
                 return true;
             }
         }

         return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
