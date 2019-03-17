public class RemoveNElement {

    public ListNode removeNElment(ListNode head, int n) {
        /*
        *  dummy -> 1 -> 2 -> 3 -> 4 -> null
        *                     slow      fast
        *  slow          fast
        *
        *                slow           fast
        *  slow               fast
        *
        *
        *
        * dummy -> 1 -> 2 -> 3 -> 4
        *         slow      fast
        *
        *
        * dummy -> 1 -> null
        *
        * */

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(n >= 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        if (fast != null) {
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
        }


        return dummy.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
