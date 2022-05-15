package com.array;

public class ConsecutiveCharacters {
    // constraint
    // 1 <= s.length <= 500
    //
    public int maxPower(String s) {
        int max = Integer.MIN_VALUE;
        int currentPower = 0;
        for(int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentPower++;
            } else {
                currentPower = 1;
            }

            max = Math.max(currentPower, max);
        }


        return max;
    }
}
