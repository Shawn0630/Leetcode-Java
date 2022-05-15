package com.array;

public class MaximizeDistancetoClosestPerson {
    // [1,0,0,0,1,0,1]
    // 1,       0,      0,      0,      1,      0,      1
    //
    public int maxDistToClosest(int[] seats) {
        int[] nextSeatedOnRight = new int[seats.length];
        int[] nextSeatedOnLeft = new int[seats.length];
        int prev = -1;
        for(int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                nextSeatedOnLeft[i] = i;
                prev = i;
            } else {
                nextSeatedOnLeft[i] = prev;
            }
        }

        prev = -1;
        for(int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                nextSeatedOnRight[i] = i;
                prev = i;
            } else {
                nextSeatedOnRight[i] = prev;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int left = nextSeatedOnLeft[i] == -1 ? Integer.MAX_VALUE : i - nextSeatedOnLeft[i];
                int right = nextSeatedOnRight[i] == -1? Integer.MAX_VALUE : nextSeatedOnRight[i] - i;
                max = Math.max(max, Math.min(left, right));
            }
        }

        return max;
    }
}
