package com.array.intervals;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> treemap = new TreeMap<>();
        for(int[] trip : trips) {
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];

            treemap.put(from, treemap.getOrDefault(from, 0) + passenger);
            treemap.put(to, treemap.getOrDefault(to, 0) -passenger);
        }

        int currentCapacity = 0;
        for(int t : treemap.keySet()) {
            currentCapacity += treemap.get(t);
            if (currentCapacity > capacity) return false;
        }

        return true;
    }
}
