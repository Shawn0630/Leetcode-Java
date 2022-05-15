package com.search;

public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1_000_000_007;
        int lcm = a / gcd(a, b) * b;

        long right = (long)n * Math.min(a, b);
        long left = 0;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (mid / a + mid / b - mid / lcm < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        return (int) (left % MOD);
    }

    private int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return gcd(y % x, x);
    }
}
