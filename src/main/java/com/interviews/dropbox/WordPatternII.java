package com.interviews.dropbox;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> patternMatch = new HashMap<>();
        Set<String> usedStr = new HashSet<>();

        return isMatch(patternMatch, usedStr, 0, pattern, 0, s);
    }

    // abc = 3
    // abcd
    // 0 + 3
    private boolean isMatch(Map<Character, String> patternMatch, Set<String> usedStr, int pIndex, String pattern, int sIndex, String s) {
        if (pIndex == pattern.length() && sIndex == s.length()) {
            return true;
        } else if (pIndex >= pattern.length() || sIndex >= s.length()) {
            return false;
        }

        char c = pattern.charAt(pIndex);
        if (patternMatch.containsKey(c)) {
            String matchString = patternMatch.get(c);
            String potentialMatch = s.substring(sIndex, Math.min(s.length(), sIndex + matchString.length()));
            if (potentialMatch.equals(matchString)) {
                return isMatch(patternMatch, usedStr, pIndex + 1, pattern, sIndex + matchString.length(), s);
            } else {
                return false;
            }
        } else {
            for(int i = sIndex; i < s.length(); i++) {
                String matchString = s.substring(sIndex, i + 1);
                if (usedStr.contains(matchString)) {
                    continue;
                }
                patternMatch.put(c, matchString);
                usedStr.add(matchString);
                if (isMatch(patternMatch, usedStr, pIndex + 1, pattern, i + 1, s)) return true;
                patternMatch.remove(c);
                usedStr.remove(matchString);

            }

            return false;
        }
    }
}
