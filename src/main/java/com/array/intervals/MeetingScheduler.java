package com.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {

    //       -----          -----           -------         ------          -------
    // ----               -----               ----             -------                  -------
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int[][] overlaps = new int[slots1.length + slots2.length][];
        int idx = 0;

        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        int p1 = 0, p2 = 0;

        while (p1 < slots1.length && p2 < slots2.length) {
            if (slots1[p1][0] > slots2[p2][1]) {
                p2++;
                continue;
            }
            if (slots1[p1][1] < slots2[p2][0]) {
                p1++;
                continue;
            }

            if (Math.min(slots1[p1][1], slots2[p2][1]) - Math.max(slots1[p1][0], slots2[p2][0]) >= duration) {
                return Arrays.asList(Math.max(slots1[p1][0], slots2[p2][0]), Math.max(slots1[p1][0], slots2[p2][0]) + duration);
            }
            if (slots1[p1][1] < slots2[p2][1]) {
                p1++;
            } else {
                p2++;
            }
            //overlaps[idx++] = new int[]{Math.max(slots1[p1][0], slots2[p2][0]), Math.min(slots1[p1][1], slots2[p2][1])};
        }


        return new ArrayList<>();
    }
}
