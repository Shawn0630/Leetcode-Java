package com.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    // one interval -> multiple intersect
    // https://leetcode.com/problems/interval-list-intersections/discuss/1593579/JAVA-or-Two-Pointers-or-Most-Intutive
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null || firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        if (firstList.length > secondList.length) {
            return intervalIntersection(secondList, firstList);
        }

        int sp = 0;
        List<Integer[]> list = new ArrayList<>();
        // one interval -> one intersect => missing ans
//        for(int[] interval : firstList) {
//            int start = interval[0];
//            int end = interval[1];
//
//            while (secondList[sp][1] < start) sp++;
//            if (secondList[sp][0] > end) continue;
//            list.add(new Integer[]{Math.max(start, secondList[sp][0]), Math.min(end, secondList[sp][1])});
//        }

        int fp = 0;
        while(fp < firstList.length && sp < secondList.length) {
            int start = firstList[fp][0];
            int end = firstList[fp][1];

            while (sp < secondList.length && secondList[sp][1] < start) sp++;
            if (sp >= secondList.length || secondList[sp][0] > end) {
                fp++;
                continue;
            }
            int intersectX = Math.max(start, secondList[sp][0]);
            int intersectY = Math.min(end, secondList[sp][1]);
            list.add(new Integer[]{intersectX, intersectY});
            if (intersectY < end) {
                sp++;
            } else {
                fp++;
            }
        }


        int[][] ans = new int[list.size()][];
        int idx = 0;
        for(Integer[] intersect : list) {
            ans[idx++] = new int[]{intersect[0], intersect[1]};
        }

        return ans;
    }

    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        if (firstList.length > secondList.length) {
            return intervalIntersection(secondList, firstList);
        }

        int[][] ans = new int[firstList.length + secondList.length][];
        int idx = 0;
        //  ---  --- --- ---
        //    -------- ----
        //
        for(int i = 0; i < firstList.length; i++){
            for(int j = 0; j < secondList.length; j++) {
                if (isOverlap(firstList[i], secondList[j])) {
                    int start = Math.max(firstList[i][0], secondList[j][0]);
                    int end = Math.min(firstList[i][1], secondList[j][1]);
                    ans[idx++] = new int[]{start, end};
                }
            }
        }

        return Arrays.copyOf(ans, idx);
    }

    // [10,12](fp)         [18,19]
    // [1,6]        [8,11]     [13,17](sp)        [19,20](sp)
    //
    public int[][] intervalIntersection3(int[][] firstList, int[][] secondList) {
        if (firstList.length > secondList.length) {
            return intervalIntersection(secondList, firstList);
        }

        int[][] ans = new int[firstList.length + secondList.length][];
        int idx = 0;
        int fp = 0, sp = 0;

        while (fp < firstList.length && sp < secondList.length) { // fix one side
            int[] interval1 = firstList[fp];

            //       ----            ----     ------        ----          ----
            // -----              -----        ---             ----               ------

            //       -----
            // ----

            //   ----         interval[1] > second[sp][1]
            // ----          => sp++;

            //    -----       interval[1] > second[sp][1]
            //     ---        => sp++

            //   -----         interval[1] < second[sp][1]
            //      -----      => fp++;

            //   -----
            //          ------

            //     -----
            // ---------        either
            while (sp < secondList.length && secondList[sp][1] < interval1[0]) sp++; // secondList[sp][1] >= interval1[0]
            if (sp == secondList.length || interval1[1] < secondList[sp][0]) {     //interval1[1] >= secondList[sp][0]
                    fp++;
                    continue;
            }

            int start = Math.max(interval1[0], secondList[sp][0]);
            int end = Math.min(interval1[1], secondList[sp][1]);
            ans[idx++] = new int[]{start, end};

            if (interval1[1] < secondList[sp][1]) {
                fp++;
            } else {
                sp++;
            }

        }


        return Arrays.copyOf(ans, idx);
    }

    // [1, 5], [2, 6] => true
    // [1, 5], [5, 6] => true
    // [1, 5], [2, 3] => true
    // [1, 2], [3, 4] => false
    // --- ---      ----         -----
    //  ----           -----
    //  --

    // [13, 23][15,24]
    // [15, 23]
    private boolean isOverlap(int[] a, int [] b) {
// Option #1:
//        int start = Math.max(a[0], b[0]);
//        int end = Math.min(a[1], b[1]);
//        // incorrect if b[0] < b[1] < a[0] < a[1]
//        return start <= end;

// Option #2:
        return a[1] >= b[0] && b[1] >= a[0];
    }

    // o(n^2)
    public int[][] intervalIntersection4(int[][] firstList, int[][] secondList) {
        int[][] ans = new int[firstList.length + secondList.length][];
        int idx = 0; // index of ans;

        for(int i = 0; i < firstList.length; i++) {
            for(int j = 0; j < secondList.length; j++) {
                int max = Math.max(firstList[i][0], secondList[j][0]);
                int min = Math.min(firstList[i][1], secondList[j][1]);
                if (max <= min) { // check for each intervals
                    ans[idx++] = new int[]{max, min};
                }
            }
        }

        return Arrays.copyOf(ans, idx);
    }

    // sorted?
    //      a    a[0] > b[1]                                             a[1] > b[0]
    //    b                                                                  b

    //                       a         a
    //                   b             b
    //      -----      ------       ------          -----           ------
    // ----         -------          ----              ------               ------
    //[[0,2],       [5,10],     [13,23],        [24,25]]
    // fi
    //[[1,5],       [8,12],     [15,24],        [25,26]]
    //   si
    //     a[0] < b[1]
    //      ---
    //   --------
    public int[][] intervalIntersection5(int[][] firstList, int[][] secondList) {

        int fi = 0; // first list pointer
        int si = 0; // second list pointer
        int[][] ans = new int[firstList.length + secondList.length][];
        int idx = 0;// tracking the ans

        while (fi < firstList.length && si < secondList.length) {
            if (firstList[fi][0] > secondList[si][1]) { // 0 > 5 false
                si++;
                continue;
            } // f[fi][0] <= second[si][1]
            if (firstList[fi][1] < secondList[si][0]) { // 2 > 1 true fi++
                fi++;
                continue;
            }
            // firstList[fi][0] <= second[si][1] &&
            // first[fi][1] <= second[si][0]
            int max = Math.max(firstList[fi][0], secondList[si][0]);
            int min = Math.min(firstList[fi][1], secondList[si][1]);

            ans[idx++] = new int[]{max, min};

            if (firstList[fi][1] > secondList[si][1]) {
                si++;
            } else {
                fi++;
            }

        }

        return Arrays.copyOf(ans, idx);

    }


    //        0-----
    // ------1

    //  ------fp[1]
    // -----sp[1]    sp[1] < fp[1] => sp++;

    //  0-------1    sp[1] < fp[1] => sp++;
    //   0----1

    //  0-----1       sp[1] > fp[1] => fp++;
    //    0-----1

    // 0-----1
    //    0------1


    // -----
    //          -------

    // intersections fp[1] >= sp[0] && sp[1] >= fp[0]

    // [[0,2],      [5,10],     [13,23],        [24,25]]
    //  fp
    // [[1,5],      [8,12],     [15,24],        [25,26]]
    //   sp
    public int[][] intervalIntersection6(int[][] firstList, int[][] secondList) {
        int fp = 0, sp = 0;
        int[][] ans = new int[firstList.length + secondList.length][];
        int idx = 0;

        while (fp < firstList.length && sp < secondList.length) {
            int[] first = firstList[fp];
            int[] second = secondList[sp];

            // moving fp
            if (first[1] < second[0]) { // 2 < 1
                fp++;
                continue;
            }

            // moving sp
            if (second[1] < first[0]) { // 1 < 0
                sp++;
                continue;
            }
            // f[1] >= s[0] && s[0] >= f[1]

            int max = Math.max(first[0], second[0]);
            int min = Math.min(first[1], second[1]);
            ans[idx++] = new int[]{max, min};

            if (second[1] < first[1]) {
                sp++;
            } else {
                fp++;
            }
        }

        return Arrays.copyOf(ans, idx);
    }

    //           -----           -------        -----
    //             ------         ----       -----
    private boolean isOverlap2(int[] a, int[] b) {
        int max = Math.max(a[0], b[0]);
        int min = Math.min(a[1], b[1]);

        return max <= min;// [1,1] is valid overlap
    }
}
