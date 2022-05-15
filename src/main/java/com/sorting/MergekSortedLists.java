package com.sorting;

import com.linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for(ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            prev.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            prev = node;
        }

        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        int interval = 1;
        while (interval < lists.length) {
            for(int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = merge2List(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }

        return lists[0];
    }

    private ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    prev.next = cur1;
                    prev = cur1;
                    cur1 = cur1.next;
                } else {
                    prev.next = cur2;
                    prev = cur2;
                    cur2 = cur2.next;
                }
            } else if (cur1 != null){
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            } else {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }

        return dummy.next;
    }
}
