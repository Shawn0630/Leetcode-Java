package com.search.binary_search;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;

        for(int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEat(int[] piles, int rate, int h) {
        int sum = 0;
        for(int pile : piles) {
            sum += pile / rate;
            if (pile % rate != 0) {
                sum += 1;
            }
        }

        return sum <= h;
    }
}
