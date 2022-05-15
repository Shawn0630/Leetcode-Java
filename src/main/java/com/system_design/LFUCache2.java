package com.system_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache2 {
    Map<Integer, DoubleLinedList> freqList;
    Map<Integer, Integer> freq;
    Map<Integer, DoubleLinkedListNode> nodeMap;
    int capacity;
    int min_freq;

    public LFUCache2(int capacity) {
        freqList = new HashMap<>();
        nodeMap = new HashMap<>();
        freq = new HashMap<>();
        min_freq = 0;

        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        } else {
            freqList.putIfAbsent(1, new DoubleLinedList());
            DoubleLinkedListNode node = nodeMap.get(key);
            freqList.get(1).moveToFront(node);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            freq.put(key, freq.getOrDefault(key, 0) + 1);
            freqList.putIfAbsent(freq.get(key), new DoubleLinedList());
            DoubleLinkedListNode node = nodeMap.get(key);
            freqList.get(freq.get(key)).moveToFront(node);
        } else {
            if (nodeMap.size() > capacity) {
                DoubleLinkedListNode node = freqList.get(min_freq).removeTail();
                freq.remove(node.key);
                nodeMap.remove(node.key);
            }
            freqList.putIfAbsent(1, new DoubleLinedList());
            min_freq = 1;
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            nodeMap.put(key, newNode);
            freqList.get(1).appendFront(newNode);
        }
    }

    private class DoubleLinedList {
        DoubleLinkedListNode head, tail;

        public DoubleLinedList() {
            head = new DoubleLinkedListNode( -1, -1);
            tail = new DoubleLinkedListNode( -1, -1);
            head.next = tail;
            tail.prev = head;
        }


        // head -> prev -> node -> next -> end
        //  prev -> next;
        // next <- prev;
        private void moveToFront(DoubleLinkedListNode node) {
            DoubleLinkedListNode prev = node.prev;
            DoubleLinkedListNode next = node.next;
            prev.next = next;
            next.prev = prev;

            node.next = head.next; // use local variable, otherwise easy to miss
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        // head -> a -> tail
        //
        private void appendFront(DoubleLinkedListNode node) {
            DoubleLinkedListNode next = head.next;
            next.prev = node;
            node.next = next;

            node.prev = head;
            head.next = node;
        }

        // head -> ..-> prev -> node -> tail
        private DoubleLinkedListNode removeTail() {
            DoubleLinkedListNode node = tail.prev;
            DoubleLinkedListNode prev = node.prev;

            prev.next = tail;
            tail.prev = prev;

            node.next = null;
            node.prev = null;

            return node;
        }

    }

    private class DoubleLinkedListNode {
        private int key;
        private int value;
        private DoubleLinkedListNode prev, next;

        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public static void main(String[] args) {
        LFUCache2 lfuCache2 = new LFUCache2(2);
        //[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        lfuCache2.put(1, 1);
        lfuCache2.put(2, 2);
        lfuCache2.get(1);
        lfuCache2.put(3, 3);
        lfuCache2.get(2);
        lfuCache2.put(4, 4);
        lfuCache2.get(1);
        lfuCache2.get(3);
        lfuCache2.get(4);
    }


}
