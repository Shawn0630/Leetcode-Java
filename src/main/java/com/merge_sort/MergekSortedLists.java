package com.merge_sort;

import com.linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    // https://blog.csdn.net/alex_xfboy/article/details/87967704
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode node : lists) {
            if (node != null) queue.offer(node);
        }

        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            if (smallest.next != null) {
                queue.offer(smallest.next);
            }
            cur.next = smallest;
            cur = cur.next;
        }

        return dummy.next;
    }
}
