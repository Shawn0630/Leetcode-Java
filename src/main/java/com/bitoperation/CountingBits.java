package com.bitoperation;

public class CountingBits {
    public int[] countBits(int num) {
        if (num <= 0) {
            return new int[]{};
        }

        int[] ans = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
