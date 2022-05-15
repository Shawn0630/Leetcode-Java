package com.interviews.dropbox.oa;


import java.util.TreeSet;

public class LongestSegment {

    // 3    1   2
    // 1    1   2

    //
    public int[] longestSegment(int[] queries) {
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        int idx = 0;
        int max = 0;
        for(int query : queries) {
            int[] updated = updateTreeSet(set, query);
            ans[idx++] = Math.max(max, updated[1] - updated[0] + 1);
        }

        return ans;
    }

    private int[] updateTreeSet(TreeSet<int[]> set, int query) {
        int[] floor = set.floor(new int[]{query, query});
        int[] interval = new int[]{query, query};

        //[2,4] [7, 9] 1 => [1,4]
        //[2,4] [7, 9] 2 => [2,4] // condition #1
        //[2,4] [7, 9] 3 => [2,4] // condition #1
        //[2,4] [7, 9] 4 => [2,4] // condition #1
        //[2,4] [7, 9] 5 => [2,5] // condition #2
        //[2,4] [7, 9] 6
        //[2,4] [7, 9] 7
        //[2,4] [7, 9] 8
        //[2,4] [7, 9] 9
        //[2,4] [7, 9] 10
        if(floor != null) {
            if (query <= floor[1]) {
                return floor;
            } else if (floor[1] == query - 1) {
                set.remove(floor);
                interval[0] = floor[0];
            }
        }

        int[] ceil = set.ceiling(new int[]{query, query});
        if (ceil != null) {
            if (ceil[0] == query + 1) {
                set.remove(ceil);
                interval[1] = ceil[1];
            }
        }

        set.add(interval);

        return interval;
    }

    public static void main(String[] args) {
        LongestSegment longestSegment = new LongestSegment();
        int[] quires = new int[]{2, 1, 3};
        int[] ans = longestSegment.longestSegment(quires);
        for(int num : ans) {
            System.out.println(num + " ");
        }
    }
}
