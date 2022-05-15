package com.system_design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomPickwithBlacklist {
    List<Integer> allowedList;
    Set<Integer> blockedList;
    int N;
    public RandomPickwithBlacklist(int n, int[] blacklist) {
        blockedList = new HashSet<>();
        allowedList = new ArrayList<>();
        N = n;

        for(int black : blacklist) {
            blockedList.add(black);
        }
        if (blockedList.size() > n / 2) {
            for(int i = 0; i < n; i++) {
                if (!blockedList.contains(i)) {
                    allowedList.add(i);
                }
            }
        }
    }

    public int pick() {
        if (allowedList.size() > 0) {
            int i = new Random().nextInt(allowedList.size());
            return allowedList.get(i);
        } else {
            while (true) {
                int i = new Random().nextInt(N);
                if (!blockedList.contains(i)) {
                    return i;
                }
            }
        }
    }
}
