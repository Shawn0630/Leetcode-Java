package com.linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    Random random;
    List<Integer> list;
    public LinkedListRandomNode(ListNode head) {
        this.list = new ArrayList<>();
        this.random = new Random();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return this.list.get(random.nextInt(list.size()));
    }
}
