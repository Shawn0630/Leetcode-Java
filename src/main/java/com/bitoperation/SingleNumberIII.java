package com.bitoperation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null) {
            return null;
        }

        int xor = 0;

        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int bit = xor & ~(xor - 1);
        int one = 0, two = 0;

        for(int i = 0; i < nums.length; i++) {
            if ((bit & nums[i]) == 0) {
                one ^= nums[i];
            } else {
                two ^= nums[i];
            }
        }

        return new int[]{one, two};
    }
}
