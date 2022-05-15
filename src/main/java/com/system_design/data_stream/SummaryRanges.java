package com.system_design.data_stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SummaryRanges {

    // Binary Search solution: https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82602/Java-Binary-Search-upon-List
    // TreeMap Solution: https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/279760/java-solution-84ms-use-TreeMap-extremely-simple

//    Map<Integer, int[]> smap;
//    Map<Integer, int[]> emap;
//    Set<Integer> added;
//
//    public SummaryRanges() {
//        smap = new TreeMap<>();
//        emap = new TreeMap<>();
//        added = new HashSet<>();
//    }
//
//    public void addNum(int val) {
//        if (added.contains(val)) {
//            return;
//        }
//        added.add(val);
//
//        int[] startInterval = smap.get(val + 1);
//        int[] endInterval = emap.get(val - 1);
//
//        smap.remove(val + 1);
//        emap.remove(val - 1);
//
//        int[] mergedInterval = new int[] {endInterval == null ? val : endInterval[0],
//                                          startInterval == null ? val : startInterval[1]};
//        smap.put(mergedInterval[0], mergedInterval);
//        emap.put(mergedInterval[1], mergedInterval);
//    }
//
//    public int[][] getIntervals() {
//        return smap.values().toArray(new int[smap.size()][]);
//    }

    // TreeSet solution

//    TreeSet<int[]> set;
//    public SummaryRanges() {
//        set = new TreeSet<>((a,b) -> a[0] - b[0]); // key comparison
//    }
//
//    public void addNum(int val) {
//        int[] interval = new int[]{val, val};
//
//        int[] floor = set.floor(interval);
//        if (floor != null) { // the point is in a interval
//            if (val <= floor[1]) {   //[1,2][4,5] [3] => [1, 3]
//                return;
//            } else if (val == floor[1] + 1) {
//                set.remove(floor);
//                interval[0] = floor[0];
//            }
//        }
//
//        int[] ceil = set.higher(interval);
//        if (ceil != null) {
//            if (ceil[0] == val + 1) {   // [1, 5]
//                interval[1] = ceil[1];
//                set.remove(ceil);
//            }
//        }
//
//        set.add(interval); // add a discrete point
//    }
//
//    public int[][] getIntervals() {
//        return set.toArray(new int[set.size()][]);
//    }

    // https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/1693523/Java-Solution-or-Binary-Search-or-TreeMap

    TreeMap<Integer, Integer> treeMap;
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    //      [3, 5]   [7, 8]
    // 1
    // 2
    // 4
    // 6
    // 7
    public void addNum(int val) {
        int start = val;
        int end = val;

        Integer floor = treeMap.floorKey(val);

        if (floor != null) {
            int floorEnd = treeMap.get(floor);
            if (val <= floorEnd) {
                return;
            } else if (val == floorEnd + 1){
                start = floor;
                treeMap.remove(floor);
            }
        }

        Integer ceil = treeMap.ceilingKey(val);
        if (ceil != null) {
            if (val == ceil - 1) {
                end = treeMap.get(ceil);
                treeMap.remove(ceil);
            }
        }

        treeMap.put(start, end);
    }

    public int[][] getIntervals() {
        int[][] ans = new int[treeMap.size()][2];

        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            ans[idx][0] = entry.getKey();
            ans[idx++][1] = entry.getValue();
        }

        return ans;
    }

}
