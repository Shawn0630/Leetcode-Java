package com.strings;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }

        int first = -1;
        int second = -1;
        boolean canSwitch = false;
        int[] count = new int[26];
        // check if able to switch with the same character.

        for (int i = 0; i < A.length(); i++) {
            if (++count[A.charAt(i) - 'a'] >= 2)  canSwitch = true;
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }

        return (first == -1 && canSwitch) || ( first != -1 && second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
    }
}
