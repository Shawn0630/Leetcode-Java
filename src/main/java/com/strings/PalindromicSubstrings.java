package com.strings;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        String newS = preProcess(s);
        int[] P = new int[newS.length()];

        int C = 0;
        int R = 0;
        for(int i = 1; i < newS.length() - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);
            } else {
                P[i] = 0;
            }

            while (newS.charAt(i + 1 + P[i]) == newS.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            if (P[i] + i > R) {
                R = P[i] + i;
                C = i;
            }
        }

        int ans = 0;
        for(int i = 0; i < P.length; i++) {
            ans += (P[i] + 1) / 2;
        }

        return ans;

    }

    private String preProcess(String s) {
        if (s == null) {
            return s;
        }
        if (s.length() == 0) {
            return "^$";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for(int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        sb.append('$');

        return sb.toString();
    }

    public int countSubstrings2(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }

       int count = 0;
       for(int i = 0; i < s.length(); i++) {
           count += expandCenter(i, i + 1, s);
           count += expandCenter(i, i, s);
       }

       return count;
    }

    private int expandCenter(int left, int right, String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
