package com.strings;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) return false;

        int[] next = new int[s.length()];
        char[] cs = s.toCharArray();

        next[0] = 0;
        int j = 0;
        for(int i = 1; i < cs.length; i++) {
            while(j > 0 && cs[i] != cs[j]) j = next[j - 1];
            if (cs[i] == cs[j]) j++;
            next[i] = j;
        }

        return (next[s.length() - 1] != 0) && (s.length() % (s.length() - next[s.length() - 1]) == 0);
    }
}
