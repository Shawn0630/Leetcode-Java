public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1_cur = l1;
        ListNode l2_cur = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1_cur != null && l2_cur != null) {
            int sum = l1_cur.val + l2_cur.val + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            l1_cur = l1_cur.next;
            l2_cur = l2_cur.next;
            cur = cur.next;
        }
        while (l1_cur != null) {
            int sum = l1_cur.val + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            l1_cur = l1_cur.next;
            cur = cur.next;
        }
        while (l2_cur != null) {
            int sum = l2_cur.val + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            l2_cur = l2_cur.next;
            cur = cur.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
