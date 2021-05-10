package com.strings;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        String revS = new StringBuilder(s).reverse().toString();
        String newS = s + "#" + revS;
        int[] next = new int[newS.length()];

        int j = 0;
        for(int i = 1; i < newS.length(); i++) {
            while (j > 0 && newS.charAt(i) != newS.charAt(j)) j = next[j - 1];
            if (newS.charAt(i) == newS.charAt(j)) j++;
            next[i] = j;
        }

        return revS.substring(0, s.length() - next[newS.length() - 1]) + s;
    }
}
