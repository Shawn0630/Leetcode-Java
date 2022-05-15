package com.simulation;

public class AddStrings {
    // https://leetcode.com/problems/add-strings/discuss/90491/JAVA-Simple-and-Clean-with-Explanations-29-ms
    public String addStrings(String num1, String num2) {
        int num1p = num1.length() - 1;
        int num2p = num2.length() - 1;

        String res = "";
        int carry = 0;
        while (num1p >= 0 && num2p >= 0) {
            int a = num1.charAt(num1p) - '0';
            int b = num2.charAt(num2p) - '0';
            int sum = a + b + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            res = sum + res;

            num1p--;
            num2p--;
        }

        while (num1p >= 0) {
            int a = num1.charAt(num1p) - '0';
            int sum = a + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            res = sum + res;
            num1p--;
        }

        while (num2p >= 0) {
            int a = num2.charAt(num2p) - '0';
            int sum = a + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            res = sum + res;
            num2p--;
        }

        if (carry == 1) {
            res = 1 + res;
        }

        return res;
    }
}
