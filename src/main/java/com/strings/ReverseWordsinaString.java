package com.strings;

public class ReverseWordsinaString {
    // https://leetcode.com/problems/reverse-words-in-a-string/discuss/1488987/Easy-java-code!-no-split()-no-reverse()-no-StringBuilder
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        String sub = "";

        int i = 0;
        int j = 0;
        while(i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ')i++;
            if (i == s.length()) break;
            j = i;
            while (j < s.length() && s.charAt(j) != ' ')j++;
            sub = s.substring(i, j);
            res = res.equals("") ? sub : sub + " " + res;
            i = j;
        }

        return res;

    }
}
