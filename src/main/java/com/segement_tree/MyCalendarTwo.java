package com.segement_tree;

import java.util.TreeMap;

public class MyCalendarTwo {

    // https://leetcode.com/problems/my-calendar-ii/discuss/1407723/Java-TreeMap-Solution
    TreeMap<Integer, Integer> treeMap;
    public MyCalendarTwo() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int active_events_any_time = 0;
        for(Integer event : treeMap.values()) {
            active_events_any_time += event;

            if (active_events_any_time > 2) {
                treeMap.put(start, treeMap.get(start) - 1);
                treeMap.put(end, treeMap.get(end) + 1);
                return false;
            }
        }

        return true;
    }
}
