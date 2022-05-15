package com.sorting;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> pair = priorityQueue.poll();
            int freq = pair.getValue();
            Character character = pair.getKey();
            while (freq > 0) {
                sb.append(character);
                freq--;
            }
        }

        return sb.toString();
    }
}
