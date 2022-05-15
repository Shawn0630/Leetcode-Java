package com.segement_tree;

import java.util.TreeMap;

public class MyCalendarThree {

    TreeMap<Integer, Integer> treeMap;
    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int active_event_anytime = 0;
        int max = Integer.MIN_VALUE;
        for(Integer overlap : treeMap.values()) {
            active_event_anytime += overlap;
            max = Math.max(max, active_event_anytime);
        }

        return max;
    }
}
