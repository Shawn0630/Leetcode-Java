package com.sorting;

import java.util.Arrays;

public class SmallestValueoftheRearrangedNumber {
    public long smallestNumber(long num) {
        boolean negative = false;
        if (num < 0) {
            negative = true;
        }

        char[] numChars = String.valueOf(num).toCharArray();
        // 103
        // 013 => 103

        if (negative) {
            Arrays.sort(numChars, 1, numChars.length);
        } else {
            Arrays.sort(numChars, 0, numChars.length);
        }

        StringBuilder sb = new StringBuilder();
        if (negative) {
            sb.append('-');
            for(int i = numChars.length - 1; i >= 1; i--) {
                sb.append(numChars[i]);
            }
        } else {
            // 0 1 2 3
            // 0 0 0 1
            // i = 3

            int i = 0;
            while (i < numChars.length && numChars[i] == '0') i++;
            if (i < numChars.length) {
                sb.append(numChars[i]);
            }
            for(int j = 0; j < i; i++) {
                sb.append('0');
            }
            i++;
            while (i < numChars.length) {
                sb.append(numChars[i]);
                i++;
            }
        }

        return Long.parseLong(sb.toString());
    }
}
