package com.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null
                || s.length() == 0 || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int length = words[0].length();
        int n = words.length;

        for(int i = 0; i < s.length() - n * length + 1; i++) {
            Map<String, Integer> temp = new HashMap<>();
            int j;
            for(j = 0; j < n; j++) {
                String str = s.substring(i + j * length, i + (j + 1) * length);
                temp.put(str, temp.getOrDefault(str, 0) + 1);
                if (temp.get(str) > map.getOrDefault(str, 0)) break;
            }

            if (j == n) {
                result.add(i);
            }
        }

        return result;
    }


    public List<Integer> findSubString2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null
        || s.length() == 0 || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int gap = words[0].length();
        int length = words.length;

        for(int i = 0; i < gap; i++) {
            Map<String, Integer> temp = new HashMap<>();
            int left = i;
            int count = 0;
            for(int j = i; j <= s.length() - gap; j+= gap) { // j == rightmost
                String str = s.substring(j, j + gap);

                if (map.containsKey(str)) {
                    temp.put(str, temp.getOrDefault(str, 0) + 1);
                    if (temp.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while (temp.get(str) > map.get(str)) {
                            String leftmost = s.substring(left, left + gap);
                            temp.put(leftmost, temp.get(leftmost) - 1);
                            if (temp.get(leftmost) < map.get(leftmost)) count--;
                            left += gap;
                        }
                    }

                    if(count == length) {
                        result.add(left);
                        count--;
                        temp.put(s.substring(left, left + gap), temp.get(s.substring(left, left + gap)) - 1);
                        left += gap;
                    }


                } else {
                    temp.clear();
                    count = 0;
                    left = j + gap;
                }
            }
        }

        return result;
    }
}
