package com.strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // "abba"
    //"dog dog dog dog" => false
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] sarray = s.split(" ");

        if(sarray.length != pattern.length()) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            Character p = pattern.charAt(i);
            if (map.get(p) == null) {
                map.put(p, sarray[i]);
                if (map2.get(sarray[i]) != null) {
                    return false;
                } else {
                    map2.put(sarray[i], p);
                }
            } else {
                if (!map.get(p).equals(sarray[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
