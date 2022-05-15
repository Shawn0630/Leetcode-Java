package com.system_design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickwithWeight {
    // https://leetcode.com/problems/random-pick-with-weight/discuss/154044/Java-accumulated-freq-sum-and-binary-search
//    private Random random;
//    private List<Integer> list;
//    public RandomPickwithWeight(int[] w) {
//       this.list = new ArrayList<>();
//        for(int i = 0; i < w.length; i++) {
//            int cur = w[i];
//            while (cur > 0) {
//                list.add(i);
//                cur--;
//            }
//        }
//
//        this.random = new Random();
//    }
//
//    public int pickIndex() {
//        return list.get(random.nextInt(list.size()));
//    }


//    int max;
//    int[] w;
//    int[] sums;
//    Random random;
//    public RandomPickwithWeight(int[] w) {
//        this.sums = new int[w.length];
//        sums[0] = w[0];
//        for(int i = 1; i < w.length; i++) {
//            sums[i] = sums[i - 1] + w[i];
//        }
//        this.max = sums[w.length - 1];
//        this.w = w;
//        this.random = new Random();
//
//    }
//
//    public int pickIndex() {
//        int left = 0;
//        int right = w.length - 1;
//        int next = random.nextInt(sums[w.length - 1]) + 1;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2; // mid = [0, w.length - 1]
//            if (this.sums[mid] == next) {
//                return mid;
//            } else if (this.sums[mid] < next) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//
//        // left == right // left [1, w.weight]
//        return this.sums[left] < next ? left + 1 : left;
//
//    }

    // [2, 3] => [0, 0, 1, 1, 1]
    // [1, 5] random pick integer, see in which range
    // [0, 1] => 0
    // [2, 4] => 1

    //  1  2  3  4  5
    //  0  1  2  3  4
    // [0, 0, 1, 1, 1]    3   return 1
    // [2, 3]
    //  l           r
    //        m
    int[] w;      //     1
    int[] prefix; // [0, 2, 5]
    Random random;
    public RandomPickwithWeight(int[] w) {
        prefix = new int[w.length + 1];
        prefix[0] = 0;

        for(int i = 1; i < w.length + 1; i++) {
            prefix[i] = prefix[i - 1] + w[i - 1];
        }

        this.w = w;
        this.random = new Random();
    }

    public int pickIndex() {
        int pick = random.nextInt(prefix[prefix.length - 1]) + 1; // right bound is open

//        for(int i = 1; i < prefix.length; i++) {
//            if (prefix[i - 1] <= pick &&
//                pick <= prefix[i]) {
//                return i - 1;
//            }
//        }

        int left = 0, right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // [0 ... prefix.length - 2]
            if (pick == prefix[mid]) {
                return mid;
            } else if (pick < prefix[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        //  0  1  2
        // [0, 2, 5] target 1
        //  l     r
        //      m
        //  l   r
        //  m
        //      lr
        // [0, 1]
        return left - 1;
    }
}
