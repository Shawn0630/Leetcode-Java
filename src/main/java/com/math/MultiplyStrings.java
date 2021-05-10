package com.math;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] += temp % 10;
                result[i + j] += temp / 10;
            }
        }

        for(int i = result.length - 1; i >= 1; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(result[start] == 0) start++;
        for(int i = start; i < result.length; i++) {
            sb.append(result[i]);
        }


        return sb.toString();
    }
}
