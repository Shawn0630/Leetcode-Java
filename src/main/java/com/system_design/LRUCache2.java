package com.system_design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache2 {
    int capacity;
    Map<Integer, Node> map;
    Node dummyTail;
    Node dummyHead;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
       if(map.containsKey(key)) {
           Node node = map.get(key);
           removeFromList(node);
           appendToEnd(node);

           return node.value;
       } else {
           return -1;
       }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            appendToEnd(node);
            map.put(key, node);

            if (map.size() > capacity) {
                Node nodeToRemove = removeTop();
                map.remove(nodeToRemove.key);
            }
        } else {
            Node node = map.get(key);
            node.value = value;
            removeFromList(node);
            appendToEnd(node);
        }
    }

    private class Node {
        int key;
        int value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void appendToEnd(Node node) {
        // a <- -> b   c
        // a -> c, c <- a c -> b, b <- c
        dummyTail.prev.next = node;
        node.prev = dummyTail.prev;

        node.next = dummyTail;
        dummyTail.prev = node;
    }

    private void removeFromList(Node node) {
        // a <- -> b <- -> c => a <- -> c
        node.prev.next = node.next; // a -> c
        node.next.prev = node.prev;//  c <- a
    }

    private Node removeTop() {
        // dummyHead <- -> a <- -> b => dummHead <- -> b

        Node nodeToRemove = dummyHead.next;

        dummyHead.next = nodeToRemove.next;
        nodeToRemove.next.prev = dummyHead;

        return nodeToRemove;
    }
}
