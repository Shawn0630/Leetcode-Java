package com.array;

import java.util.Arrays;

public class CuttingRibbons {
    // [9,7,5], k = 3
    // [5       7       9]      k = 3
    //
    public int maxLength(int[] ribbons, int k) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int ribbon : ribbons) {
            sum += ribbon;
            max = Math.max(max, ribbon);
        }

        if (sum < k) {
            return 0;
        }

        int left = 1, right = max + 1;

        // [1, 2, ... max]
        while (left < right) { // exit condition: left == right
            int mid = left + (right - left) / 2; // [1 ~ max - 1]
            int actual = 0;
            for (int ribbon : ribbons) {
                actual += ribbon / mid;
            }
            if (actual >= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        // left ~ [1 ~ max]
        return left - 1;
    }

    public static void main(String[] args) {
        CuttingRibbons cuttingRibbons = new CuttingRibbons();
        cuttingRibbons.maxLength(new int[]{100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,1,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000},
        49);
    }
}
