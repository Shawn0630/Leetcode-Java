package com.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSwap {
    // 2    7   3   6 => 7  2   3   6

    // 7    2   3   6 => 7  6   3   2

    // 7     6   2   3 => 7  6   3   2
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            map.putIfAbsent(c - '0', new ArrayList<>());
            map.get(c - '0').add(i);
        }

        int targetPos = 0;
        int sourcePos = -1;
        int digit = 9;

        while (digit >= 0) {
            if (map.get(digit) != null) {
                List<Integer> poses = map.get(digit);

                for(Integer pos : poses) {
                    if (pos > targetPos) {
                        sourcePos = pos;
                    } else {
                        targetPos++;
                    }
                }
                if (sourcePos != -1) {
                    break;
                }
            }

            digit--;
        }

        if (targetPos < chars.length) {
            char temp = chars[targetPos];
            chars[targetPos] = chars[sourcePos];
            chars[sourcePos] = temp;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
