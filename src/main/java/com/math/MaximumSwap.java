package com.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSwap {
    // num is greater or equal to 0
    // https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
    public int maximumSwap(int num) {
        List<Integer> digits = getIntList(num);
        for(int i = digits.size() - 1; i >= 0; i--) {
            Integer max = digits.get(i);
            boolean found = false;
            int indexToSwap = i;
            for(int j = i - 1; j >= 0; j--) {
                if (digits.get(j) >= max && !digits.get(j).equals(digits.get(i))) {
                    found = true;
                    indexToSwap = j;
                    max = digits.get(j);
                }
            }
            if (found) {
                swap(digits, i, indexToSwap);
                break;
            }
        }

        return convert(digits);
    }

    // get each digit of the num in reverse order
    private List<Integer> getIntList(int num) {
        if (num == 0) {
            return Arrays.asList(0);
        }

        List<Integer> ans = new ArrayList<>();
        while (num != 0) {
            ans.add(num % 10);
            num /= 10;
        }

        return ans;
    }

    private int convert(List<Integer> list) {
        int ans = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            ans = ans * 10 + list.get(i);
        }

        return ans;
    }

    private void swap(List<Integer> list, int i, int j) {
        if (i < 0 || i >= list.size() ||
            j < 0 || j >= list.size()) {
            return;
        }

        int temp;
        temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        return;
    }
}
