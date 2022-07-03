package com.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    // abba     dogcatcatdog
    public boolean workPatternMatch(String pattern, String str) {
        return workPatternMatch(pattern, str, 0, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean workPatternMatch(String pattern, String str, int pIdx, int strIdx, Map<Character, String> map, Set<String> usedStr) {
       if (strIdx >= str.length() && pIdx >= pattern.length()) {
           return true;
       } else if (strIdx >= str.length() || pIdx >= pattern.length()) {
           return false;
       }

       Character p = pattern.charAt(pIdx);
       if(map.containsKey(p)) {
           String matching = map.get(p);
           if (!str.startsWith(matching, strIdx)) {
               return false;
           } else {
               // abc, abc
               // 0
               return workPatternMatch(pattern, str, pIdx + 1, strIdx + matching.length(), map, usedStr);
           }
       } else {
           StringBuilder sb = new StringBuilder();
           for(int i = strIdx; i < str.length(); i++) {
               sb.append(str.charAt(i));
               if (usedStr.contains(sb.toString())) continue;
               usedStr.add(sb.toString());
               map.put(p, sb.toString());
               if (workPatternMatch(pattern, str, pIdx + 1, i + 1, map, usedStr)) return true;
               map.remove(p);
               usedStr.remove(sb.toString());
           }
       }

       return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordPatternII().workPatternMatch("abba", "dogcatcatdog"));
    }
}
