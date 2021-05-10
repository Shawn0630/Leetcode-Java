package com.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            Arrays.fill(count, 0);

            char[] chars = str.toCharArray();
            for(char c : chars) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count.length; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
