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

    public int hammingWeight2(int n) {
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                counter++;
            }
        }

        return counter;
        // 0001
        // 0010
        // 0100
        // 1000
    }
}
