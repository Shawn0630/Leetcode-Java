package com.tree;

import com.linked_list.ListNode;

public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end) {
        // important!!!
        if(start == end) return null;

        ListNode mid = findMid(start, end);
        if (mid == null) {
            return null;
        }
        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(start, mid);
        root.right = sortedListToBST(mid.next, end);

        return root;
    }

    private ListNode findMid(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // https://zhuanlan.zhihu.com/p/36124969

}
