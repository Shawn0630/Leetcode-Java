package com.linked_list;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FlattenaMultilevelDoublyLinkedList {

    public static Node flatten(Node head) {
        flattenDFS(head);
        return head;
    }

    private static Node flattenDFS(Node head) { // return this current last element in the list
        if (head == null) {
            return null;
        }

        Node cur = head;
        while(cur != null) {
            if (cur.child != null) {
                Node next = cur.next;

                cur.next = cur.child;
                cur.child.prev = cur;

                Node node = flattenDFS(cur.child);
                cur.child = null;

                if (node != null && next != null) {
                    node.next = next;
                    next.prev = node;
                }
            } else if (cur.next == null) {
                return cur;
            }

            cur = cur.next;
        }

        return null;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    };

    static class NodeBuilder {
        List<Node> nodes = new ArrayList<>();

        public NodeBuilder addNode(int val) {
            nodes.add(new Node(val));

          return this;
        }

        public Node getNode(int index) {
            return nodes.get(index);
        }

        public Node build() {
            Node prev = null;
            for(Node node : nodes) {
                node.prev = prev;

                if (node.prev != null) {
                    node.prev.next = node;
                }

                prev = node;
            }

            return nodes.get(0);
        }
    }

    public static void main(String[] args) {
        NodeBuilder node1Builder = new NodeBuilder()
                .addNode(1)
                .addNode(2)
                .addNode(3)
                .addNode(4)
                .addNode(5)
                .addNode(6);
        Node node1 = node1Builder.build();


        NodeBuilder node2Builder = new NodeBuilder()
                .addNode(7)
                .addNode(8);
        Node node2 = node2Builder.build();

        NodeBuilder node3Builder = new NodeBuilder()
                .addNode(11)
                .addNode(12);

        Node node3 = node3Builder.build();

        node1Builder.getNode(2).child = node2;
        node2Builder.getNode(1).child = node3;

//        NodeBuilder node1Builder = new NodeBuilder().addNode(1);
//        Node node1 = node1Builder.build();
//
//        NodeBuilder node2Builder = new NodeBuilder().addNode(2);
//        Node node2 = node2Builder.build();
//
//        NodeBuilder node3Builder = new NodeBuilder().addNode(3);
//        Node node3 = node3Builder.build();
//
//        node1.child = node2;
//        node2.child = node3;
        
        Node ans = flatten(node1);
    }
}
