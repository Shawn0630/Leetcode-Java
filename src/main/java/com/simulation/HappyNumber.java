package com.simulation;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            n = nextInteger(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        } // exit condidtion n == 1

        return true;
    }

    private int nextInteger(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }
}
