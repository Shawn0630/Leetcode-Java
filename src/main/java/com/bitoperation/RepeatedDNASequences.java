package com.bitoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <= 10) {
            return new ArrayList<>();
        }

        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 9) cur = removeLeft(cur);
            cur = addToRight(cur, s.charAt(i));
            if (i >= 9) {
                if (map.containsKey(cur)) {
                    if (map.get(cur) == 1) {
                        list.add(s.substring(i - 9, i + 1));
                    }
                    map.put(cur, map.get(cur) + 1);
                } else {
                    map.put(cur, 1);
                }
            }
        }

        return list;
    }


    private int removeLeft(int cur) {
        return cur & ((1 << 18) - 1); // - 1, flip the 0 to 1 before the first 1 on the rightmost, refer to https://blog.whezh.com/bit-hacks/
    }

    private int addToRight(int cur, char c) {
        cur = cur << 2;
        switch (c) {
            case 'A':
                cur = cur | 0x0;
                break;
            case 'T':
                cur = cur | 0x1;
                break;
            case 'G':
                cur = cur | 0x2;
                break;
            case 'C':
                cur = cur | 0x3;
                break;
            default:
        }

        return cur;
    }
}
