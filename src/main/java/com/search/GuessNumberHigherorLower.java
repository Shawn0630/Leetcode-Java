package com.search;

public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        int mid = 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            int result = guess(mid);
            if (result == 0) break;

            if (result < 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left == right ? left : mid;
    }

    int guess(int num) {
      return 1;
    }
}
