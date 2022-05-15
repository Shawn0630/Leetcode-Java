package com.dynamic_programming;

public class WildcardMatching {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return isMatch(s, s.length() - 1, p, p.length() - 1);
    }

    // "adceb"
    // "*a*b"

    private boolean isMatch(String s, int si, String p, int pi) {
        // a
        if (si < 0 && pi < 0) {
            return true;
        } else if (si < 0) { // pi != 0 a *
           for (int i = 0; i <= pi; i++) {
               if (p.charAt(i) != '*') return false;
            }
           return true;
        } else if (pi < 0) {
            return false;
        } else { // si >= 0 && pi >= 0

            if (dp[si][pi] != null) {
                return dp[si][pi];
            }

            char sc = s.charAt(si);
            char pc = p.charAt(pi);

            if (pc == '*') {
                dp[si][pi] = isMatch(s, si - 1, p, pi) || isMatch(s, si - 1, p, pi - 1) || isMatch(s, si, p, pi - 1);
            } else if (pc == '?') {
                dp[si][pi] = isMatch(s, si - 1, p, pi - 1);
            } else { // pi != *
                dp[si][pi] = sc == pc && isMatch(s, si - 1, p, pi - 1);
            }

            return dp[si][pi];
        }
    }
}
