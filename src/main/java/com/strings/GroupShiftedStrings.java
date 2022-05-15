package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupShiftedStrings {
    // assumptions/constraints
    // 1. no empty string
    // 2. no null array, or empty array
    // 3. string contains lower case only
    public List<List<String>> groupStrings(String[] strings) {
        Set<Integer> grouped = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        int[][] patterns = new int[strings.length][];
        int idx = 0;
        for(String s : strings) {
            patterns[idx] = new int[s.length() - 1];
            for(int i = 1; i < s.length(); i++) {
                patterns[idx][i - 1] = s.charAt(i) > s.charAt(i - 1) ? s.charAt(i) - s.charAt(i - 1) - 26 :
                        s.charAt(i) - s.charAt(i - 1); // keep in mind z -> a
            }
            idx++;
            // z - a = 1 az => 1 26
            // az  ba
            // (25 + 26) % 26  (-1 + 26) % 26
            // 25
        }

        // ab = [1]
        // a = []
        for(int i = 0; i < strings.length; i++) {
            if (grouped.contains(i)) continue;
            String a = strings[i];
            List<String> group = new ArrayList<>();
            group.add(a);
            grouped.add(i);
            for(int j = i + 1; j < strings.length; j++) {
                if (grouped.contains(j)) continue;
                String b = strings[j];
                if (a.length() != b.length()) continue;
                // a.length == b.length
                if (Arrays.equals(patterns[i], patterns[j])) {
                    group.add(b);
                    grouped.add(j);
                }
            }
            ans.add(group);
        }


        return ans;
    }

    public List<List<String>> groupStrings2(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s:strings) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    // "abc" => "11"
    // "zab" => "11"
    // a -> 0  z -> 25
    // a - z = (-25 + 26) % 26
    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1); // i >= 1
            sb.append((cur - prev + 26) % 26)
                    .append(" ");
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();
        groupShiftedStrings.getKey("al");
    }
}
