package com.search;

public class ArrangingCoins {
    // https://leetcode.com/problems/arranging-coins/discuss/1559930/3-Java-Solution-with-Explanations%3A-Iterative-Binary-Search-and-Math
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n / 2;

        long currentCoins = 0;
        while (left < right) {
            long mid = left + (right - left) / 2;
            currentCoins = sum(mid);
            if (n == currentCoins) return (int) mid;
            else if (n > currentCoins) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        // left == right

        long leftSum = sum(left);
        long leftPlusOneSum = sum(left + 1);
        long leftMinusOneSum = sum(left - 1);

        if (n >= leftMinusOneSum && n < leftSum) {
            return (int)left - 1;
        } else if (n >= leftSum && n < leftPlusOneSum) {
            return (int)left;
        } else {
            return (int)left + 1;
        }
    }

    private long sum(long n) {
        return (1 + n) * n / 2;
    }

    public static void main(String args[]) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        arrangingCoins.arrangeCoins(10);
    }
}
