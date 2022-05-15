package com.array.intervals;

import java.util.Map;
import java.util.TreeMap;

public class FindIntervals {

    Map<Integer, Integer> map;
    Map<Integer, int[]> smap;
    Map<Integer, int[]> emap;
    public FindIntervals() {
        map = new TreeMap<>();
        smap = new TreeMap<>();
        emap = new TreeMap<>();
    }

    public void add(int[] interval) {
        map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
        map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);

        smap.put(interval[0], interval);
        emap.put(interval[1], interval);
    }

    // [1, 3], [3, 5] => [3]
    // 1 -> 1, 3 - > 1, 3 - > 0, 5 -> -1
    public int[][] overlaps() {
       return new int[][]{};
    }

    public int[][] merge() {
        return new int[][]{};
    }
}
