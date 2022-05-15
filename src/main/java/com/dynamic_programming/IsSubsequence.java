package com.dynamic_programming;

public class IsSubsequence {

    // s is the subsequent of t
    // s = "abc", t = "ahbgdc"
    // a    h   b   g   d   c
    // 0    0   1   1   1   2
    public boolean isSubsequence(String s, String t) {

        int sdx = 0;
        int tdx = 0;
        while (tdx < t.length() && sdx < s.length()) {
            if (s.charAt(sdx) == t.charAt(tdx)) {
                sdx++;
            }
            tdx++;
        }

        return sdx == s.length();
    }
}
