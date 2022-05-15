package com.bitoperation;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int i = 32;
        int count = 0;
        while (i > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
            i--;
        }

        return count;
    }
}
