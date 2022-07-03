package com.sorting;

import java.util.Arrays;

public class MaximumUnitsonaTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int count = 0;
        int box = 0;
        int idx = 0;
        while (box < truckSize && idx < boxTypes.length) {
            int i = 0;
            while (box < truckSize && i < boxTypes[idx][0]) {
                count += boxTypes[idx][1];
                box++;
                i++;
            }
            idx++;
        }

        return count;
    }
}
