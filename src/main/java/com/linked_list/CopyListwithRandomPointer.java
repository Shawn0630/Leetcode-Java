package com.linked_list;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // assumptions/constraints
    // 1. val is not the key, could be duplicated
    // 2. could be null list
    // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    //     0             1              2             3           4
    //  (7, null)  =>  (13, 0)   =>   (11, 4)  =>  (10, 2)   =>  (1, 0)
    //

    // if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
    // https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
    // https://leetcode.com/problems/copy-list-with-random-pointer/discuss/1059181/C%2B%2B-or-Three-Pass-or-O(n)-0ms-Beats-100-or-Explanation-(with-example)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node dummy = new Node(-1);
        Node prev = dummy;

        Map<Node, Node> map = new HashMap<>();

        while (cur != null) {
            Node node = map.getOrDefault(cur, new Node(cur.val));
            map.put(cur, node); // IMPORTANT !!!!

            // node.random
            if(cur.random != null) {
                map.putIfAbsent(cur.random, new Node(cur.random.val));
                node.random = map.get(cur.random);
            }

            // prev.next
            prev.next = node;

            cur = cur.next;
            prev = prev.next;
        }

        return dummy.next;
    }


    // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    public Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        Node newHead = null;
        Node prev = null;

        while (cur != null) {
            Node copied = map.getOrDefault(cur, new Node(cur.val));
            map.put(cur, copied);

            if (prev != null) {
                prev.next = copied;
            }

            if (newHead == null) {
                newHead = copied;
            }

            Node copiedRandom;
            if(cur.random != null) {
                if (map.get(cur.random) == null) {
                    copiedRandom = new Node(cur.random.val);
                    map.put(cur.random, copiedRandom);
                } else {
                    copiedRandom = map.get(cur.random);
                }
                copied.random = copiedRandom;
            }



            prev = copied;
            cur = cur.next;
        }

        return newHead;
    }
}

