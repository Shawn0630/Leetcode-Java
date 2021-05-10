package com.strings;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
             return 0;
        }
        int[] next = calculateNext(needle);

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int j = 0;
        for(int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystacks[i] != needles[j]) j = next[j - 1];
            if (haystacks[i] == needles[j])j++;
            if (j == needles.length) return i - j + 1;
        }

        return -1;
    }

    private int[] calculateNext(String needle) {
        if (needle == null) {
            return null;
        }

        int[] next = new int[needle.length()];
        char[] cs = needle.toCharArray();

        int j = 0;
        for(int i = 1; i < needle.length(); i++) {
            while (j > 0 && cs[j] != cs[i]) j = next[j - 1];
            if (cs[j] == cs[i]) j++;
            next[i] = j;
        }

        return next;
    }
}
