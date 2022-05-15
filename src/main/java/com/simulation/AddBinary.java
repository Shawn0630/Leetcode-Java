package com.simulation;

public class AddBinary {
    // assumption/constraints
    // 1. no null or empty string
    // 2. String consists of 0 or 1 only
    public String addBinary(String a, String b) {
        int ap = a.length() - 1;
        int bp = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (ap >= 0 || bp >= 0 || carry != 0) {
            int avalue = ap >= 0 ? a.charAt(ap) - '0' : 0;
            int bvalue = bp >= 0 ? b.charAt(bp) - '0' : 0;

            // 0 0 ~ 0
            // 0 1 ~ 1
            // 1 0 ~ 1
            // 1 1 ~ 10
            // 1 1 1 ~ 11
            int sum = avalue + bvalue + carry;
            carry = sum / 2;
            sum = sum % 2; // 2 % 2 = 0, 1 % 2 = 1, 3 % 2 = 1;

            sb.insert(0, sum);
            ap--;
            bp--;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("1", "1");
    }
}
