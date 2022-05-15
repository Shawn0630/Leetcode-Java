package com.system_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class FreqStack {
//    Map<Integer, Integer> freqMap;
//    PriorityQueue<Node> queue;
//    int id;
//    public FreqStack() {
//        freqMap = new HashMap<>();
//        queue = new PriorityQueue<>((n1, n2) -> {
//            if (n1.freq == n2.freq) {
//                return n2.id - n1.id;
//            } else {
//                return n2.freq - n1.freq;
//            }
//        });
//        id = 0;
//    }
//
//    public void push(int val) {
//        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
//        queue.offer(new Node(id, freqMap.get(val), val));
//        this.id = this.id + 1;
//    }
//
//    public int pop() {
//        Node n = queue.poll();
//        freqMap.put(n.val, freqMap.get(n.val) - 1);
//        return n.val;
//    }
//
//    private class Node {
//        int id;
//        int freq;
//        int val;
//
//        public Node(int id, int freq, int val) {
//            this.id = id;
//            this.freq = freq;
//            this.val = val;
//        }
//    }
    List<Stack<Integer>> bucket;
    Map<Integer, Integer> freq;
    int maxFreq;

    public FreqStack() {
        bucket = new ArrayList<>();
        freq = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        while (bucket.size() < freq.get(val)) {
            bucket.add(new Stack<>());
        }
        bucket.get(freq.get(val) - 1).push(val);
        maxFreq = Math.max(maxFreq, freq.get(val));
    }

    public int pop() {
        int returnedVal = bucket.get(maxFreq - 1).pop();
        while (maxFreq > 0 && bucket.get(maxFreq - 1).isEmpty()) {
            bucket.remove(maxFreq - 1);
            maxFreq--;
        }
        freq.put(returnedVal, freq.get(returnedVal) - 1);

        return returnedVal;

    }
}
