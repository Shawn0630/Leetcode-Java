package com.system_design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    LinkedList list;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList();
    }

    // update position in O(1)
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        list.removeNode(node);
        list.moveToTail(node);

        return map.get(key).val;
    }


    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            list.removeNode(map.get(key));
        }

        list.moveToTail(node);
        map.put(key, node);
        if (map.size() > capacity) {
            map.remove(list.getHead().key);
            list.removeHead();
        }
    }


    private class Node {
        Node next;
        Node prev;
        Integer key;
        Integer val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    private class LinkedList {

        private Node head;
        private Node tail;

        public LinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public Node getHead() {
            return head.next;
        }

        public Node getTail() {
            return tail.prev;
        }

        public void pushNode(Node node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            node.next = tail;
        }

        public Node removeHead() {
            head.next = head.next.next;
            head.next.prev = head;

            return head.next;
        }

        public Node removeTail() {
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;

            return tail.prev;
        }

        public void removeNode(Node node) {
            if (node != null && node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        public void moveToHead(Node node) {
            if (node != null) {
                head.next.prev = node;
                node.next = head.next.prev;
                head.next = node;
                node.prev = head;
            }
        }

        public void moveToTail(Node node) {
            if (node != null) {
                tail.prev.next = node;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev = node;
            }
        }
    }
}
