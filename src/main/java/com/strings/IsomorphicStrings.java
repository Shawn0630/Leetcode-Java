package com.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> smap = new HashMap<>();
        Set<Character> tset = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (smap.containsKey(sc) && smap.get(sc) != tc) {
                return false;
            } else if (!smap.containsKey(sc)) {
                if (tset.contains(tc)) {
                    return false;
                }
                smap.put(sc, tc);
                tset.add(tc);
            }
        }

        return true;
    }
}
