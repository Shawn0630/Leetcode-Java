public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode ap = headA;
        ListNode bp = headB;

        while (ap != bp) {
           ap = ap == null ? headB : ap.next;
           bp = bp == null ? headA : bp.next;
        }

        return ap;

    }

    public static class ListNode {
        int val;
        IntersectionofTwoLinkedLists.ListNode next;
        ListNode(int x) { val = x; }
    }
}
