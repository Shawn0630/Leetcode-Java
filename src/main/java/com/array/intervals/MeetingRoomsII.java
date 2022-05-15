package com.array.intervals;

import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomsII {
    // [[0,30],[5,10],[15,20]]

    // 0 => 1
    // 30 => -1
    // 5 => 1
    // 10 => -1
    // 15 => 1
    // 20 => -1

    // 0    5   10      15      20      30
    // 1    2   1       2       1       0
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> treemap = new TreeMap<>();
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            treemap.put(start, treemap.getOrDefault(start, 0) + 1);
            treemap.put(end, treemap.getOrDefault(end, 0) - 1);
        }


        int counter = 0;
        int ans = 0;
        for(Integer time : treemap.keySet()) {
            counter += treemap.get(time);
            ans = Math.max(counter, ans);
        }

        return ans;
    }


    // A


}
