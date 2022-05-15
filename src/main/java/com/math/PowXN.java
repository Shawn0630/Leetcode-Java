package com.math;

public class PowXN {
    // https://leetcode.com/problems/powx-n/discuss/19544/5-different-choices-when-talk-with-interviewers
    public double myPow(double x, int n) {
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = -n;
        }

        double result = myPowDFS(x, n);

        if (isNeg) {
            return 1.0 / result;
        } else {
            return result;
        }

    }

    // x ^ n = [x ^ (n/2)] ^ 2 = (x ^ 2) ^ (n / 2)
    public double myPow2(double x, int n) {
       int m = Math.abs(n);

       return n < 0 ? 1 / myPow2DFS(x, m) : myPow2DFS(x, m);
    }

    // n >= 0
    private double myPow2DFS(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        return n % 2 == 0 ? myPow2DFS(x * x, n / 2) : x * myPow2DFS(x * x, n / 2);
    }

    private double myPowDFS(double x, int n) {

        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            double result = myPowDFS(x, n / 2);
            return result * result;
        } else {
            double result = myPowDFS(x, n / 2);
            return x * result * result;
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        powXN.myPow(1.00000, -2147483648);
    }
}
