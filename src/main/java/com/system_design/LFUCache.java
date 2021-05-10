package com.system_design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private Map<Integer, Node> map;
    private Map<Integer, DLinkedList> freq;
    private int capacity;
    private int min_feq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freq = new HashMap<>();
        min_feq = 1;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        } else {
            Node node = map.get(key);
            freq.get(node.freq).remove(node);
            if (min_feq == node.freq && freq.get(node.freq).isEmpty()) {
                min_feq++;
            }
            node.freq++;
            freq.computeIfAbsent(node.freq, ignore -> new DLinkedList());
            freq.get(node.freq).push_head(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.get(key) == null) {
            if (map.size() == capacity) {
                Node node = freq.get(min_feq).remove_tail();
                map.remove(node.key);
            }

            Node node = new Node(key, value);
            freq.computeIfAbsent(node.freq, ignore -> new DLinkedList());
            freq.get(node.freq).push_head(node);
            map.put(key, node);
            min_feq = 1;
        } else {
            get(key);
            map.get(key).value = value;
        }

    }

    private class Node {
        int key;
        int freq;
        int value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

    private class DLinkedList {
        Node head, tail;
        int size;

        DLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void push_head(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next= node;
            node.prev = head;
            size++;
        }

        public Node remove_tail() {
            if (size == 0) {
                return null;
            }


            Node node = tail.prev;

           remove(node);

            return node;
        }

        public void remove(Node node) {
            size--;
            node.next.prev = node.prev;
            node.prev.next = node.next;

            node.next = null;
            node.prev = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}

