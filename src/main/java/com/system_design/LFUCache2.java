package com.system_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class LFUCache2 {
    // https://leetcode.com/problems/lfu-cache/discuss/2029072/JAVA-or-HashMap-or-No-DLL-or-Easy-to-Understand
    Map<Integer, Integer> cache;
    Map<Integer, Integer> keyFreq;
    Map<Integer, LinkedHashSet<Integer>> freqs;
    int capacity;
    int min;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyFreq = new HashMap<>();
        this.freqs = new HashMap<>();
        this.min = 1;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        int freq = keyFreq.get(key);
        freqs.get(freq).remove(key);
        if (freq == min && freqs.get(freq).size() == 0) {
            min = freq + 1;
        }
        freqs.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqs.get(freq + 1).add(key);
        keyFreq.put(key, freq + 1);

        return cache.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }

        if (this.cache.size() >= this.capacity) {
            int removeKey = this.freqs.get(min).iterator().next();
            keyFreq.remove(removeKey);
            cache.remove(removeKey);
            this.freqs.get(min).remove(removeKey);
        }

        min = 1;
        this.freqs.putIfAbsent(min, new LinkedHashSet<>());
        this.freqs.get(min).add(key);
        this.keyFreq.put(key, min);
        this.cache.put(key, value);
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
