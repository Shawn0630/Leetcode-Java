package com.array;

public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String s, char c) {
        if (s == null || s.length() == 0) {
            return new int[]{};
        }

        int[] ans = new int[s.length()];
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                prev = i;
            } else if (prev == Integer.MAX_VALUE) {
                ans[i] = Integer.MAX_VALUE;
            } else {
                ans[i] = i - prev;
            }
        }

        prev = Integer.MAX_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (c == s.charAt(i)) {
                prev = i;
            } else {
                int rightDist = prev == Integer.MAX_VALUE ? Integer.MAX_VALUE : prev - i;
                ans[i] = Math.min(ans[i], rightDist);
            }
        }

        return ans;
    }
}
