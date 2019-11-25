package com.bitoperation;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedStringUniqueCharacters {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        List<Integer> ints = new ArrayList<>();
        for(String s : arr) {
            if (s == null) continue;
            char[] cs = s.toCharArray();
            int mask = 0;
            for (char c : cs) {
                    mask |= (1 << c - 'a');
            }
            if (Integer.bitCount(mask) == s.length()) {
                ints.add(mask);
            }
        }

        int ans = 0;
        for(int i = 0; i < (1 << ints.size()); i++) {
            int mask = 0;
            for(int j = 0; j < ints.size(); j++) {
                if ((i & (1 << j)) != 0) { // 1 - pick; 0 - not pick
                    if ((mask & ints.get(j)) == 0) {
                        mask |= ints.get(j);
                    }
                }
            }
            ans = Math.max(ans, Integer.bitCount(mask));
        }

        return ans;
    }
}
