package com.search.binary_search;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        int left = max, right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int usedDay = useDay(mid, weights);
            if (usedDay <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;

    }

    private int useDay(int capacity, int[] weights) {
        int sum = 0;
        int usedDay = 1;
        for(int i = 0; i < weights.length; i++) {
            if (capacity < sum + weights[i]) {
                sum = 0;
                usedDay++;
            }
            sum += weights[i];
        }

        return usedDay;
    }
}
