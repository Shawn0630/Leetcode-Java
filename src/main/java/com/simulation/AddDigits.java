package com.simulation;

public class AddDigits {
    public int addDigits(int num) {
        String numStr = String.valueOf(num);

        while (numStr.length() != 1) {
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                sum += numStr.charAt(i) - '0';
            }
            numStr = String.valueOf(sum);
        }

        return Integer.parseInt(numStr);
    }
}
