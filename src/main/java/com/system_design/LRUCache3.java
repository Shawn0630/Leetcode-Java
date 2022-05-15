package com.system_design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    Map<Integer, Node> map;
    Node dummyHead;
    Node dummyTail;
    int capacity;
    public LRUCache3(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    // return -1 if not exist
    // get the value
    // move to the tail;
    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        } else { // map.get(key) != null
            Node value = map.get(key);
            removeFromList(value);
            moveToTail(value);
            return value.value;
        }
    }

    // allowing duplicates
    // not exceed capacity => add entry, add to tail
    // exceed capacity => add entry, remove the head
    public void put(int key, int value) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            this.get(key);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);

            if (map.size() > this.capacity) {
                Node nodeToRemove = removeFromHead();
                map.remove(nodeToRemove.key);
            }
        }
    }

    // a <-> dummyTail
    // a <-> b <-> dummyTail
    private void moveToTail(Node node) {
        dummyTail.prev.next = node;// a->b
        node.prev = dummyTail.prev;// a<-b
        node.next = dummyTail; // b->dummyTail
        dummyTail.prev = node; // b<-dummyTail
    }

    // a<->b<->c => a<->c
    private void removeFromList(Node node) {
        node.prev.next = node.next; // a->c
        node.next.prev = node.prev; // a<-c
    }


    // dummy <-> a <-> b
    // return a
    private Node removeFromHead() {
        Node nodeToReturn = dummyHead.next;

        dummyHead.next = nodeToReturn.next; // dummy -> b
        nodeToReturn.next.prev = dummyHead; // b <- a

        return nodeToReturn;
    }

    private class Node {
        int key;
        int value;

        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
